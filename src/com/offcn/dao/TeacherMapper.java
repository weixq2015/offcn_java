package com.offcn.dao;

import com.offcn.pojo.Student;
import com.offcn.pojo.Teacher;
import com.offcn.pojo.TeacherExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

	List<Teacher> getlist(Map<String, Object> map);

	int getNum();


	void deleteByPrimaryKey(List<Integer> id);
	void deleteByOne(int id);
	int addTea(Teacher stu);

	Teacher getById(int id);

	List<Teacher> getAllTea();

	Teacher login(Teacher tea);



}