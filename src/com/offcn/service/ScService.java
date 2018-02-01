package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Sc;

public interface ScService {
	public void saveSc(Sc sc);
	public  List<Sc> getStuBytid(int tid);
	public List<Sc>  getStuBySid(int sid);
}
