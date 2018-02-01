package com.offcn.pojo;

public class Student {
    private Integer id;

    private String name;

    private String sex;

    private String address;

    private String tel;

    private Integer classid;

    private Integer usertype;

    private String password;

    private String loginname;

    private String files;
    
    private Classes classes;
    
    private Course course;
    
    private Grade  grade;
    
    private Sc sc;
    
    private Teacher teacher;
    

    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Sc getSc() {
		return sc;
	}

	public void setSc(Sc sc) {
		this.sc = sc;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + ", tel=" + tel
				+ ", classid=" + classid + ", usertype=" + usertype + ", password=" + password + ", loginname="
				+ loginname + ", files=" + files + ", classes=" + classes + ", course=" + course + ", grade=" + grade
				+ ", sc=" + sc + ", teacher=" + teacher + "]";
	}
    
    
    
}