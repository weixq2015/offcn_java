package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;
import com.offcn.pojo.CourseExt;
import com.offcn.pojo.CtcKey;
import com.offcn.pojo.Sc;
import com.offcn.pojo.Student;
import com.offcn.pojo.Teacher;
import com.offcn.service.ClassesService;
import com.offcn.service.CourseService;
import com.offcn.service.CtcService;
import com.offcn.service.ScService;
import com.offcn.service.StuService;
import com.offcn.service.TeaService;


@Controller
@RequestMapping("/cou")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	@Autowired
	TeaService teaService;
	@Autowired
	ClassesService classService;
//	@Autowired
//	CourseExt couExt;
	@Autowired
	StuService stuService;
	@Autowired
	ScService scService;
	@Autowired
	CtcService ctcService;
	
	

   @RequestMapping	
   public String getList(Model model,@RequestParam(defaultValue="1",required=false) int pageNO){
	  //每页多少条
	  int size=3;
	  List<Course> clist=courseService.getlist(pageNO, size);
	  model.addAttribute("clist", clist);
	  //获取总条数
	  int count=courseService.getNum();
	  model.addAttribute("pageNO", pageNO);
	  model.addAttribute("size", size);
	  model.addAttribute("count", count);
//	  System.out.println(slist.size()+"一共的信息总数");
	  return "cou/list"; 
   }
   @RequestMapping("/delete")	
   public String delete(Model model,@RequestParam("id") List<Integer> id){
	   courseService.deleteByPrimaryKey(id);
	return "redirect:/cou";	 
   }
 
   @RequestMapping("/showedit/{id}")	
   public String edit(Model model,Course record,@PathVariable int id){
	   /*stuService.updateByPrimaryKey(record);
	   return "redirect:/stu";*/
	   //根据id查找对象
	   courseService.getById(id);
	   
	   model.addAttribute("cou", record);
	   return "cou/edit";
	 
   }
   
   
   @RequestMapping("/edit")	
   public String edit(Course record){
	   record.setType(record.getType());
	   courseService.updateByPrimaryKey(record);
	   return "redirect:/cou";
   }
   @RequestMapping("/showadd")	
   public String add(Model model){
	  Course cou=new  Course();	 
	  model.addAttribute("course", cou);
	   return "/cou/add";
   }
   @RequestMapping("/add")	
   public String addStu(Model model,Course cou){
	   courseService.addCou(cou);
	   return "redirect:/cou";
   }
   @RequestMapping("/setctc/{id}")	
   public String setctc(Model model,CourseExt couExt ,@PathVariable int id){
	  Course course=courseService.getById(id);
	   List<Teacher> tlist=teaService.getAllTea();
	   List<Classes>  clist = classService.getAllClassess();
	   couExt.setName(course.getName());
		  model.addAttribute("courseExt", couExt);
		  model.addAttribute("clist", clist);
		  model.addAttribute("tlist", tlist);
	   return "/cou/setctc";
   }
   
   @RequestMapping("/editSavect")
	 public String editSavect(Model model,CourseExt courseExt,RedirectAttributes rs){
		 
		 if(courseExt.getCids().size()==0 ||courseExt.getTeacher().getId()<1){
			  rs.addFlashAttribute("message", "请填写完整排课信息");
			  return "redirect:/cou";
		 }
		 List<String>  classids= courseExt.getCids();
		 for(String cid:classids){
			 CtcKey ctc = new CtcKey();
			 ctc.setClaid(Integer.parseInt(cid));
			 ctc.setCouid(courseExt.getId());
			 ctc.setTid(courseExt.getTeacher().getId());
			 Sc   sc = new Sc();			 
			 if(courseService.getById(courseExt.getId()).getType().equals("必修")){				 
				 sc.setCid(courseExt.getId());
				 sc.setTid(courseExt.getTeacher().getId());
				 int claid = Integer.parseInt(cid);
				 List<Student> stulist = stuService.getStusByIds(claid);
				 for(Student stu:stulist){
					 sc.setSid(stu.getId());
					 scService.saveSc(sc);
				 }
			 }
			 ctcService.saveCtc(ctc);			 
		 }
		 return "redirect:/cou";
   }
 /*  @RequestMapping("/editSavect")	
   public String editSavect(Model model,Course cou){
	   courseService.addCou(cou);
	   return "redirect:/cou";
   }*/

}
