package com.offcn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;
import com.offcn.pojo.CourseExt;
import com.offcn.pojo.CtcKey;
import com.offcn.pojo.Grade;
import com.offcn.pojo.Sc;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;
import com.offcn.service.ClassesService;
import com.offcn.service.CourseService;
import com.offcn.service.CtcService;
import com.offcn.service.GradeService;
import com.offcn.service.ScService;
import com.offcn.service.StuService;
import com.offcn.service.TeaService;

@Controller
@RequestMapping("/tea")
public class TeaController {
	
	@Autowired
	TeaService teaService;
	@Autowired
	CtcService ctcService;
	@Autowired
	CourseService courseService;
	@Autowired
	ClassesService  classesService;
	
	@Autowired
	ScService  scService;
	
	@Autowired
	StuService  stuService;
	
	@Autowired
	GradeService  gradeService;
	

	
   @RequestMapping	
   public String getList(Model model,@RequestParam(defaultValue="1",required=false) int pageNO){
	  //每页多少条
	  int size=4;
	  List<Teacher> slist=teaService.getlist(pageNO, size);
	  model.addAttribute("tealist", slist);
	  //获取总条数
	  int count=teaService.getNum();
	  model.addAttribute("pageNO", pageNO);
	  model.addAttribute("size", size);
	  model.addAttribute("count", count);
//	  System.out.println(slist.size()+"一共的信息总数");
	  return "tea/list"; 
   }
   @RequestMapping("/delete")	
   public String delete(Model model,int id){
	   teaService.deleteByOne(id);
	return "redirect:/tea";
	}
	@RequestMapping("/deletes")	
	   public String deletes(Model model,@RequestParam("id") List<Integer> id){
		   teaService.deleteByPrimaryKey(id);
		return "redirect:/tea";
	 
   }
   
   @RequestMapping("/showedit/{id}")	
   public String edit(Model model,Teacher tea,@PathVariable int id){
	  Teacher teacher=teaService.getById(id);
	   model.addAttribute("teacher", teacher);
	   return "tea/edit";	 
   }
 
   @RequestMapping("/edit")	
   public String edit(Teacher tea){
	   tea.setUsertype(2);
	   teaService.updateByPrimaryKey(tea);
	   return "redirect:/tea";
   }
   @RequestMapping("/showadd")	
   public String add(Model model){
	  Teacher tea=new  Teacher();		
	  model.addAttribute("teacher", tea);
	   return "/tea/add";
   }
   @RequestMapping("/add")	
   public String addTea(Model model,Teacher teacher){
	   teacher.setUsertype(2);
//	  stu.setClassid(stu.getClasses().getId());
	   teaService.addTea(teacher);
	   return "redirect:/tea";
   }
   //查看教师个人信息
   @RequestMapping("/showInfo")
   public String showInfo(Model model,HttpServletRequest req){
	   Teacher  teacher= (Teacher) req.getSession().getAttribute("user");		   
	   model.addAttribute("teacher", teacher);		   
	   return "tea/person/list";	   
   }
   //教师更新自己的密码
   @RequestMapping("/updatePwd")
   public String updatePwd(Model model,Teacher tea,HttpServletRequest req){
	   teaService.updateByPrimaryKey(tea);
	   req.getSession().setAttribute("user", tea);
	   return "redirect:/tea/showInfo";   
   }
 //教师查看自己的课表
   @RequestMapping("/mycourse")
   public String mycourse(Model model,HttpServletRequest  req){
	   Teacher  teacher= (Teacher) req.getSession().getAttribute("user");
	   List<CtcKey>  ctclist = ctcService.getBytid(teacher.getId());
	   List<CourseExt>   courselist = new ArrayList<CourseExt>();
	   for(CtcKey c:ctclist){
		   CourseExt  course = new CourseExt();
		  course.setName(courseService.getById(c.getCouid()).getName());
		  course.setType(courseService.getById(c.getCouid()).getType());
		  course.setClasses(classesService.getById(c.getClaid()));
		  courselist.add(course);
	   }
	   model.addAttribute("courselist", courselist);
	   return  "tea/person/mycourse"; 	   
   }
 //教师查看选自己课程的学生
   @RequestMapping("/mystu")
   public String mystu(Model model,HttpServletRequest  req){
	   Teacher  teacher= (Teacher) req.getSession().getAttribute("user");
	   int tid  = teacher.getId();
	   List<Sc>  sclist = scService.getStuBytid(tid);
	   List<Student>  stulist = new  ArrayList<Student>();
	   for(Sc sc:sclist){
		   Student  stu = new Student();
		   Integer sid=sc.getSid();
		   Student oldstu=stuService.getById(sid);
		   stu.setId(oldstu.getId());
		   stu.setName(oldstu.getName());
		   stu.setSex(oldstu.getSex());
		   stu.setTel(oldstu.getTel());			   
		   stu.setAddress(oldstu.getAddress());
		   Course course=courseService.getById(sc.getCid());			   
		   stu.setCourse(course);
		   Grade  grade  =  gradeService.getGraByScid(sc);
		   stu.setGrade(grade);
		   int  claid =stuService.getById(sc.getSid()).getClassid();
		   stu.setClasses(classesService.getById(claid));
		   stulist.add(stu);
	   }
	  
	   model.addAttribute("stulist", stulist);
	   return  "tea/person/mystu";
	   
   }
   
   @RequestMapping("/addgrade/{id}/{courseid}")
   public String addgrade(Model model,@PathVariable int id,@PathVariable int courseid,HttpServletRequest req){
	   Teacher  teacher= (Teacher) req.getSession().getAttribute("user");
	   int tid  = teacher.getId();
	   Sc sc = new  Sc();
	   sc.setCid(courseid);
	   sc.setSid(id);
	   sc.setTid(tid);
	   Grade  grade  =  gradeService.getGraByScid(sc);
	   model.addAttribute("grade", grade);
	   if(grade==null){
		   Grade grades = new Grade();
		   grades.setCid(courseid);
		   grades.setSid(id);
		   grades.setTid(tid);
		   model.addAttribute("grade", grades);
	   }
	   return "tea/couOftea/setgrade";
   }
   @RequestMapping("/saveGrade")
   public String saveGrade(Model model,Grade grade){
	   if(grade.getId()!=null){
		   gradeService.updateByKeyId(grade);
	   }else{			   
		   gradeService.saveGrade(grade);		   
	   }
	   return "redirect:/tea/mystu";
   }
}
