package com.offcn.pojo;

public class CtcKey {
    private Integer couid;

    private Integer tid;

    private Integer claid;
    
    private Teacher teacher;
    
    private Course course;

    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getClaid() {
        return claid;
    }

    public void setClaid(Integer claid) {
        this.claid = claid;
    }
}