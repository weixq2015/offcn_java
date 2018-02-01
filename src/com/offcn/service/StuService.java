package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Sc;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

public interface StuService {
	
   public List<StudentExt> getlist(int pageNo,int size);//��ȡѧ���б�
   public int getNum();//��ȡѧ��������
   public int updateByPrimaryKey(Student record);//����ѧ����Ϣ
   public void deleteByPrimaryKey(List<Integer> id);//ɾ��ѧ����Ϣ
   public Student getById(int id);//��ȡѧ����Ϣ
   public List<Student> getStusByIds(int sid);
   public int addStu(Student stu);//���ѧ����Ϣ
   public Student login(Student stu);

   
}
