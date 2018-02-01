package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

public interface TeaService {
	
   public List<Teacher> getlist(int pageNo,int size);////获取教师列表
   public int getNum();//获取教师总人数
   public int updateByPrimaryKey(Teacher tea);//更新教师信息
   void deleteByPrimaryKey(List<Integer> id);//删除教师信息
   void deleteByOne(int id);//删除教师信息
   public Teacher getById(int id);//获取教师信息
  int addTea(Teacher tea);
  public List<Teacher> getAllTea();
  public Teacher login(Teacher tea);
   
}
