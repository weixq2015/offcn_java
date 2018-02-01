package com.offcn.pojo;

public class Sc extends ScKey {
    private Integer tid;
    private Teacher teacher;

    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}