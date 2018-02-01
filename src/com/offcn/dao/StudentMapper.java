package com.offcn.dao;

import java.util.List;
import java.util.Map;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;

public interface StudentMapper {

   void deleteByPrimaryKey(List<Integer> id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(int id);


    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<StudentExt> getList(Map<String,Object> map);
    public int getNum();
    int addStu(Student stu);

	List<Student> getStusByids(int sid);

	Student login(Student stu);
    
}