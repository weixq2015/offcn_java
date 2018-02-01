package com.offcn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.service.ClassesService;
import com.offcn.service.StuService;


@Controller
@RequestMapping("/cla")
public class ClassController {
	@Autowired
	ClassesService classessServiec;
	@Autowired
	StuService stuService;
	
   @RequestMapping	
   public String getList(Model model,@RequestParam(defaultValue="1",required=false) int pageNO){
	  //每页多少条
	  int size=3;
	  List<Classes> slist=classessServiec.getlist(pageNO, size);
	  model.addAttribute("slist", slist);
	  //获取总条数
	  int count=classessServiec.getNum();
	  model.addAttribute("pageNO", pageNO);
	  model.addAttribute("size", size);
	  model.addAttribute("count", count);
//	  System.out.println(slist.size()+"一共的信息总数");
	  return "class/list"; 
   }
   @RequestMapping("/delete")	
   public String delete(Model model,@RequestParam("id") List<Integer> id){
	   classessServiec.deleteByPrimaryKey(id);
	return "redirect:/cla";
	 
   }
   
   @RequestMapping("/showedit/{id}")	
   public String edit(Model model,Classes record,@PathVariable int id){
	   /*stuService.updateByPrimaryKey(record);
	   return "redirect:/stu";*/
	   //根据id查找对象
	  Classes cla=classessServiec.getById(id);
	   model.addAttribute("classes", cla);
	   return "class/edit";
	 
   } 
   @RequestMapping("/edit")	
   public String edit(Classes record){
	   classessServiec.updateByPrimaryKey(record);
	   return "redirect:/cla";
   }
   @RequestMapping("/showadd")	
   public String add(Model model){
	  Classes cla=new  Classes();
	  model.addAttribute("classes", cla);
	   return "class/add";
   }
   @RequestMapping("/add")	
   public String addClass(Model model,Classes cla){
	   classessServiec.addClass(cla);
	   return "redirect:/cla";
   }

   @RequestMapping("/searchstu/{id}")
	public String searchstu(Model model,@PathVariable int id){
		Classes  cla =  classessServiec.getById(id);
		List<Classes>  clalist =new ArrayList<Classes>();
		List<Student> stulist=stuService.getStusByIds(id);
		cla.setStulist(stulist);
		clalist.add(cla);
		model.addAttribute("clalist", clalist);
		model.addAttribute("stulist", stulist);
		return   "class/stulist";
	}
		

}
