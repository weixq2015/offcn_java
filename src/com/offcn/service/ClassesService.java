package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;

public interface ClassesService {
	public List<Classes> getAllClassess();
	public List<Classes> getlist(int pageNo,int size);//��ȡ�༶�б�
	public int getNum();//��ȡ�༶������
    public int updateByPrimaryKey(Classes record);//���°༶��Ϣ
	public void deleteByPrimaryKey(List<Integer> id);//ɾ���༶��Ϣ
	public Classes getById(int id);//��ȡ�༶��Ϣ
	public int addClass(Classes cla);//��Ӱ༶��Ϣ
}
