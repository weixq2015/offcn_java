package com.offcn.dao;

import com.offcn.pojo.Course;
import com.offcn.pojo.CourseExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	List<Course> getlist(Map<String, Object> map);

	int getNum();

	void deleteByPrimaryKey(List<Integer> id);

	int addCou(Course cou);
}