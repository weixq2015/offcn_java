package com.offcn.pojo;

public class Teacher {
    private Integer id;

    private String name;

    private Integer usertype;

    private String loginname;

    private String password;

    private String workid;

    @Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", usertype=" + usertype + ", loginname=" + loginname
				+ ", password=" + password + ", workid=" + workid + "]";
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

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }
}