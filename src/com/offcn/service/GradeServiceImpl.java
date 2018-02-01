package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.GradeMapper;
import com.offcn.pojo.Grade;
import com.offcn.pojo.Sc;
@Service
public class GradeServiceImpl implements GradeService{
	@Autowired
	GradeMapper  gradeMapper;
	@Override
	public List<Grade> getGraByTid(int tid) {
		// TODO Auto-generated method stub
		return gradeMapper.getGraByTid(tid);
	}
	@Override
	public Grade getGraByScid(Sc sc) {
		// TODO Auto-generated method stub
		return gradeMapper.getGraByScid(sc);
	}
	@Override
	public void saveGrade(Grade grade) {
		// TODO Auto-generated method stub
		grade.setZgrade(grade.getKgrade()*0.6+grade.getPgrade()*0.4);
		gradeMapper.saveGrade(grade);
	}
	@Override
	public void updateByKeyId(Grade grade) {
		// TODO Auto-generated method stub
		gradeMapper.updateByKeyId(grade);
	}
}
