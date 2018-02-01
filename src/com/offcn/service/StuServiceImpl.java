package com.offcn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.StudentMapper;
import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.Teacher;

@Service
public class StuServiceImpl implements StuService {

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public List<StudentExt> getlist(int pageNo, int size) {
		// TODO Auto-generated method stub
		int start=(pageNo-1)*size;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		return studentMapper.getList(map);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return studentMapper.getNum();
	}


	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public void deleteByPrimaryKey(List<Integer> id) {
		// TODO Auto-generated method stub
		 studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addStu(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.addStu(stu);
	}

	@Override
	public List<Student> getStusByIds(int sid) {
		// TODO Auto-generated method stub
		return studentMapper.getStusByids(sid);
	}

	@Override
	public Student login(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.login(stu);
	}





	

	

}
