package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.ScMapper;
import com.offcn.pojo.Sc;
@Service
public class ScServiceImpl implements ScService {
	@Autowired
	ScMapper   scMapper;
	
	@Override
	public void saveSc(Sc sc) {
		// TODO Auto-generated method stub
		scMapper.saveSc(sc);
	}
	@Override
	public List<Sc> getStuBytid(int tid) {
		// TODO Auto-generated method stub
		return scMapper.getStuBytid(tid);
	}
	@Override
	public List<Sc> getStuBySid(int sid) {
		// TODO Auto-generated method stub
		return scMapper.getStuBySid(sid);
	}

}
