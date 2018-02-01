package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;

public interface ClassesService {
	public List<Classes> getAllClassess();
	public List<Classes> getlist(int pageNo,int size);//获取班级列表
	public int getNum();//获取班级总人数
    public int updateByPrimaryKey(Classes record);//更新班级信息
	public void deleteByPrimaryKey(List<Integer> id);//删除班级信息
	public Classes getById(int id);//获取班级信息
	public int addClass(Classes cla);//添加班级信息
}
