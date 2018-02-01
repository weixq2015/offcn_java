package com.offcn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.ClassesMapper;
import com.offcn.pojo.Classes;
@Service
public class ClassesServiceImpl implements ClassesService{
	@Autowired
	ClassesMapper classmapper;
	
	@Override
	public List<Classes> getAllClassess() {
		// TODO Auto-generated method stub
		return classmapper.getAllClassess();
	}

	@Override
	public List<Classes> getlist(int pageNo, int size) {
		// TODO Auto-generated method stub
		int start=(pageNo-1)*size;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		return classmapper.getlist( map);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return classmapper.getNum();
	}

	@Override
	public int updateByPrimaryKey(Classes record) {
		// TODO Auto-generated method stub
		return classmapper.updateByPrimaryKey(record);
	}

	@Override
	public void deleteByPrimaryKey(List<Integer> id) {
		// TODO Auto-generated method stub
		classmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Classes getById(int id) {
		// TODO Auto-generated method stub
		return classmapper.getById(id);
	}

	@Override
	public int addClass(Classes cla) {
		// TODO Auto-generated method stub
		return classmapper.addClass(cla);
	}
}
