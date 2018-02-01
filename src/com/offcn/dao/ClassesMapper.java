package com.offcn.dao;

import com.offcn.pojo.Classes;
import com.offcn.pojo.ClassesExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    public List<Classes> getAllClassess();
    public List<Classes> getlist(Map<String,Object> map);
	int addClass(Classes cla);

	Classes getById(int id);

	void deleteByPrimaryKey(List<Integer> id);

	int getNum();

}