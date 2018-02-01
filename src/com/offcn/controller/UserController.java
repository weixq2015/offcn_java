package com.offcn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.pojo.Student;
import com.offcn.pojo.Teacher;
import com.offcn.pojo.User;
import com.offcn.service.StuService;
import com.offcn.service.TeaService;
import com.offcn.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	TeaService teaService;
	@Autowired
	StuService stuService;
	
	@RequestMapping("/exit")	
	public String exit(){
		
		return "../login";
		
	}
	
   @RequestMapping("/login")	
   public String login(Model model,User user,HttpServletRequest req){
	   int role=user.getUsertype();
	   System.out.println(role+"����role");
	   if(role==1){
		  //����Ա������UserService 
		   User loginuser=userService.login(user);
		   if(loginuser!=null){
			   //��½�ɹ�����½�˺ű��浽session
			   req.getSession().setAttribute("user", loginuser);
			   return "homepage/index";
		   }else{
			   model.addAttribute("msg", "��½ʧ�ܣ�");
			   return "../login"; 
		   }
	   }else if(role==2){
		  //��ʦ������TeaService 
		   Teacher tea=new Teacher();
		   tea.setLoginname(user.getName());
		   tea.setPassword(user.getPassword());
		   Teacher loginuser=teaService.login(tea);
		   if(loginuser!=null){
			   req.getSession().setAttribute("user", loginuser);
			   return "homepage/index";
		   }
		   else{
			   model.addAttribute("msg", "��½ʧ�ܣ�");
			   return "../login";
		   }
		   
	   }else if(role==3){
		  Student stu=new Student(); 
		  stu.setName(user.getName());
		  stu.setPassword(user.getPassword());
		  Student loginuser=stuService.login(stu);
		  if(loginuser!=null){
			  req.getSession().setAttribute("user", loginuser);
			  return "homepage/index";
		  }
		  else{
			  model.addAttribute("msg", "��½ʧ�ܣ�");
			  return "../login";
		  }
	   

   }
	   return "../login";
   }
}

