package com.offcn.dao;

import com.offcn.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(User user);
    
}