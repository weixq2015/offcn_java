package com.offcn.dao;

import com.offcn.pojo.Grade;
import com.offcn.pojo.GradeExample;
import com.offcn.pojo.Sc;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
    long countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

	List<Grade> getGraByTid(int tid);

	Grade getGraByScid(Sc sc);

	void saveGrade(Grade grade);

	void updateByKeyId(Grade grade);
}