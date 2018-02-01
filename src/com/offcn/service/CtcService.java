package com.offcn.service;

import java.util.List;

import com.offcn.pojo.CtcKey;

public interface CtcService {
	public void saveCtc(CtcKey ctc);
	public List<CtcKey>  getBytid(int id);
	public List<CtcKey> getAll();

	
	
}
