package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

public interface CourseService {
	
   public List<Course> getlist(int pageNo,int size);//获取课程列表
   public int getNum();//获取课程总人数
   public int updateByPrimaryKey(Course record);//更新课程信息
   public void deleteByPrimaryKey(List<Integer> id);//删除课程信息
   public Course getById(int id);//获取课程信息
   public int addCou(Course cou);//添加课程信息
   
}
