package com.offcn.pojo;

import java.util.List;

public class Classes {
    private Integer id;

    private String name;

    private String type;

    private Integer status;
    
    private List<Student> stulist;

    public List<Student> getStulist() {
		return stulist;
	}

	public void setStulist(List<Student> stulist) {
		this.stulist = stulist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}