package com.offcn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.StudentMapper;
import com.offcn.dao.TeacherMapper;
import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

@Service
public class TeaServiceImpl implements TeaService {

	@Autowired
	TeacherMapper teaMapper;
	
	@Override
	public List<Teacher>  getlist(int pageNo, int size) {
		// TODO Auto-generated method stub
		int start=(pageNo-1)*size;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		return teaMapper.getlist(map);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return teaMapper.getNum();
	}

	@Override
	public void deleteByPrimaryKey(List<Integer> id) {
		// TODO Auto-generated method stub
		teaMapper.deleteByPrimaryKey(id);
	}


	@Override
	public int addTea(Teacher tea) {
		// TODO Auto-generated method stub
		return teaMapper.addTea(tea);
	}
	@Override
	public int updateByPrimaryKey(Teacher tea) {
		// TODO Auto-generated method stub
		return teaMapper.updateByPrimaryKey(tea);
	}

	@Override
	public Teacher getById(int id) {
		// TODO Auto-generated method stub
		return teaMapper.getById(id);
	}

	@Override
	public void deleteByOne(int id) {
		// TODO Auto-generated method stub
		teaMapper.deleteByOne(id);
	}

	@Override
	public List<Teacher> getAllTea() {
		// TODO Auto-generated method stub
		return teaMapper.getAllTea();
	}

	@Override
	public Teacher login(Teacher tea) {
		// TODO Auto-generated method stub
		return teaMapper.login(tea);
	}



	

	

}
