package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

public interface TeaService {
	
   public List<Teacher> getlist(int pageNo,int size);////��ȡ��ʦ�б�
   public int getNum();//��ȡ��ʦ������
   public int updateByPrimaryKey(Teacher tea);//���½�ʦ��Ϣ
   void deleteByPrimaryKey(List<Integer> id);//ɾ����ʦ��Ϣ
   void deleteByOne(int id);//ɾ����ʦ��Ϣ
   public Teacher getById(int id);//��ȡ��ʦ��Ϣ
  int addTea(Teacher tea);
  public List<Teacher> getAllTea();
  public Teacher login(Teacher tea);
   
}
