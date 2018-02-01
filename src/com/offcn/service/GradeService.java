package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Grade;
import com.offcn.pojo.Sc;

public interface GradeService {
	public List<Grade> getGraByTid(int tid);
	public Grade  getGraByScid(Sc sc);
	public void updateByKeyId(Grade grade);
	public void saveGrade(Grade grade);
}
