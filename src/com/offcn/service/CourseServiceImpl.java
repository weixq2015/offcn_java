package com.offcn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.CourseMapper;
import com.offcn.pojo.Course;
import com.offcn.pojo.Teacher;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper courseMapper;
	
	@Override
	public List<Course> getlist(int pageNo, int size) {
		// TODO Auto-generated method stub
		int start=(pageNo-1)*size;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		return courseMapper.getlist(map);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return courseMapper.getNum();
	}


	@Override
	public int updateByPrimaryKey(Course record) {
		// TODO Auto-generated method stub
		return courseMapper.updateByPrimaryKey(record);
	}

	@Override
	public void deleteByPrimaryKey(List<Integer> id) {
		// TODO Auto-generated method stub
		courseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Course getById(int id) {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addCou(Course cou) {
		// TODO Auto-generated method stub
		return courseMapper.addCou(cou);
	}





	

	

}
