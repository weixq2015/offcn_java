package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

public interface CourseService {
	
   public List<Course> getlist(int pageNo,int size);//��ȡ�γ��б�
   public int getNum();//��ȡ�γ�������
   public int updateByPrimaryKey(Course record);//���¿γ���Ϣ
   public void deleteByPrimaryKey(List<Integer> id);//ɾ���γ���Ϣ
   public Course getById(int id);//��ȡ�γ���Ϣ
   public int addCou(Course cou);//��ӿγ���Ϣ
   
}
