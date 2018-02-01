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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;
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
@RequestMapping("/stu")
public class StuController {
	
	@Autowired
	StuService stuService;
	@Autowired
	ClassesService classessServiec;
	@Autowired
	ScService   scService;
	@Autowired
	TeaService teaService;
	
	@Autowired
	CourseService   courseService;
	@Autowired
	CtcService ctcService;
	
	@Autowired
	GradeService   gradeService;
	
   @RequestMapping	
   public String getList(Model model,@RequestParam(defaultValue="1",required=false) int pageNO){
	  //每页多少条
	  int size=3;
	  List<StudentExt> slist=stuService.getlist(pageNO, size);
	  model.addAttribute("slist", slist);
	  //获取总条数
	  int count=stuService.getNum();
	  model.addAttribute("pageNO", pageNO);
	  model.addAttribute("size", size);
	  model.addAttribute("count", count);
//	  System.out.println(slist.size()+"一共的信息总数");
	  return "stu/list"; 
   }
   @RequestMapping("/delete")	
   public String delete(Model model,@RequestParam("id") List<Integer> id){
	   stuService.deleteByPrimaryKey(id);
	return "redirect:/stu";
	 
   }
   
   @RequestMapping("/edit/{id}")	
   public String edit(Model model,Student record,@PathVariable int id){
	   /*stuService.updateByPrimaryKey(record);
	   return "redirect:/stu";*/
	   //查询班级集合
	   List<Classes> clist=classessServiec.getAllClassess();
	   model.addAttribute("clist", clist);
	   //根据id查找对象
	   Student stu=stuService.getById(id);
	   /*stu.getClasses().setId(stu.getClassid());*/
	   Classes cla=new Classes();
	   cla.setId(stu.getClassid());
	   stu.setClasses(cla);
	   model.addAttribute("stu", stu);
	   return "stu/dit";
	 
   }
   
   
   @RequestMapping("/edit")	
   public String edit(Student record){
	   record.setUsertype(3);
	   record.setClassid(record.getClasses().getId());
	   stuService.updateByPrimaryKey(record);
	   return "redirect:/stu";
   }
   @RequestMapping("/showadd")	
   public String add(Model model){
	  Student stu=new  Student();
	  List clist =classessServiec.getAllClassess();
	  model.addAttribute("clist",clist);		
	  model.addAttribute("stu", stu);
	   return "/stu/add";
   }
   @RequestMapping("/add")	
   public String addStu(Model model,Student stu){
	   stu.setUsertype(3);
	   stu.setClassid(stu.getClasses().getId());
	   stuService.addStu(stu);
	   return "redirect:/stu";
   }
   //学生查看自己的个人信息
   @RequestMapping("/showInfo")
   public String showInfo(Model model,HttpServletRequest req){
	   Student stu=(Student) req.getSession().getAttribute("user");
	   Classes  cla = classessServiec.getById(stu.getClassid());
	   stu.setClasses(cla);
	   model.addAttribute("student",stu);
	return "stu/person/list";	   
   }
   @RequestMapping("/updatePwd")
   public String updatePwd(Model model,HttpServletRequest req,Student stu){
	   stuService.updateByPrimaryKey(stu);
	   req.getSession().setAttribute("user",stu);	   
	return "redirect:/stu/showInfo";	   
   }
   @RequestMapping("mycourse")
   public String mycourse(Model model,HttpServletRequest  req){
	   Student stu = (Student) req.getSession().getAttribute("user");
	  	int sid = stu.getId();	  	
	  	List<Sc>  sclist = scService.getStuBySid(sid);
	  	Classes  cla=classessServiec.getById(stu.getClassid());
	  	List<Student>  stulist = new ArrayList<Student>();
	  	List<Course>	clist = new ArrayList<Course>();
	  	/*stu.setClasses(cla);
	  	for(Course c : clist){
	  		stu.setCourse(c);
	  		stulist.add(stu);
	  	}*/
	  		for(Sc sc:sclist){
		  		int  courseid = sc.getCid();
		  		int  tid = sc.getTid();
		  		Teacher tea = teaService.getById(tid);
		  		sc.setTeacher(tea);
		  		System.out.println(tea);
		  		Course course = courseService.getById(courseid);
		  		Student student = new  Student();	  		
		  		student.setClasses(cla);
		  		student.setSc(sc);
		  		student.setCourse(course);
		  		stulist.add(student);
		  	
		  	}	
	   model.addAttribute("stulist", stulist);
	   return  "stu/person/mycourse";
 }
   @RequestMapping("selectCourse")
   public String selectCourse(Model model,HttpServletRequest req){
	   Student stu = (Student) req.getSession().getAttribute("user");
		  int scid = stu.getClassid();
		  System.out.println(stu.getClassid()+"这是测试打印到的学生的id");
		  System.out.println(stu.getCourse()+"这是测试打印到的学生的课程");
		  List<CtcKey>  ctclist =  ctcService.getAll();
		  List<CtcKey>   ctclist2 = new  ArrayList<CtcKey>();
		  for(CtcKey ctc:ctclist){
			  CtcKey c =new CtcKey();
			  int tid = ctc.getTid();
			  Teacher teacher = teaService.getById(tid);
			  int cid = ctc.getCouid();
			  Course  course = courseService.getById(cid);
			  int claid = ctc.getClaid();
			  System.out.println(claid+"---------------------");
			  System.out.println(scid+"============================");
			  if(claid == scid && course.getType().equals("选修")){
				  c.setTeacher(teacher);
				  c.setCourse(course);
				  ctclist2.add(c);
			  }
		  }
		  model.addAttribute("ctclist", ctclist2);
		  return "stu/person/selectcourse";  
   }
   @RequestMapping("/savecourse")
	  public String saveCourse(Model model,@RequestParam("ids") List<String> ids,HttpServletRequest req,RedirectAttributes rs){
		  Student stu = (Student) req.getSession().getAttribute("user");
		  int sid = stu.getId();		
		  if(ids!=null){			  
			  for(String id:ids){
				  Sc  sc = new Sc();
				  String []  arrid = id.split("_");
				  int  cid = Integer.parseInt(arrid[0]);
				  int  tid = Integer.parseInt(arrid[1]);
				  List<Sc>  sclist = scService.getStuBySid(sid);
				  boolean bn = true;
				  for(Sc sl:sclist){
					  if(sl.getCid()==cid){
						  bn=false;
					  }					  
				  }
				  if(bn==true){
					  sc.setSid(sid);
					  sc.setCid(cid);
					  sc.setTid(tid);				  
					  scService.saveSc(sc);
				  }else{
					  rs.addFlashAttribute("msg", "请选择不是选修的课程");
				  }				  
			  }	  
		  }else{			  
			  rs.addFlashAttribute("msg", "请至少选择一项课程");
		  }
		  return "redirect:/stu/selectCourse";
	  }
   
   @RequestMapping("/getGrade")
	  public String getGrade(Model model,HttpServletRequest req){
		  Student stu = (Student) req.getSession().getAttribute("user");
		  int sid = stu.getId();
		  List<Sc>  sclist = scService.getStuBySid(sid);
		  List<Grade>  gradelist =new ArrayList<Grade>();
		  for(Sc sc:sclist){
			Grade grade =  gradeService.getGraByScid(sc);
			if(grade ==null){
				Grade grades = new Grade();
				int tid = sc.getTid();	
				int  courseid = sc.getCid();
				Teacher teacher = teaService.getById(tid);
				grades.setTeacher(teacher);
				Course course = courseService.getById(courseid);
				grades.setCourse(course);
				gradelist.add(grades);
			}else{
				int tid = sc.getTid();	
				int  courseid = sc.getCid();
				Teacher teacher = teaService.getById(tid);
				grade.setTeacher(teacher);
				Course course = courseService.getById(courseid);
				grade.setCourse(course);
				gradelist.add(grade);
			}
		  }
		  model.addAttribute("gradelist", gradelist);
		  return "stu/person/grade";
	  }
 }
   

