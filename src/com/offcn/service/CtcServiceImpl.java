package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.CtcMapper;
import com.offcn.pojo.CtcKey;
@Service
public class CtcServiceImpl implements CtcService{
	@Autowired
	CtcMapper ctcMapper;
	@Override
	public void saveCtc(CtcKey ctc) {
		// TODO Auto-generated method stub
		ctcMapper.saveCtc(ctc);
	}
	@Override
	public List<CtcKey> getBytid(int id) {
		// TODO Auto-generated method stub
		return ctcMapper.getBytid(id);
	}
	@Override
	public List<CtcKey> getAll() {
		// TODO Auto-generated method stub
		return ctcMapper.getAll();
	}

}
