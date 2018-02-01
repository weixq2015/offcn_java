package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Sc;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

public interface StuService {
	
   public List<StudentExt> getlist(int pageNo,int size);//获取学生列表
   public int getNum();//获取学生总人数
   public int updateByPrimaryKey(Student record);//更新学生信息
   public void deleteByPrimaryKey(List<Integer> id);//删除学生信息
   public Student getById(int id);//获取学生信息
   public List<Student> getStusByIds(int sid);
   public int addStu(Student stu);//添加学生信息
   public Student login(Student stu);

   
}
