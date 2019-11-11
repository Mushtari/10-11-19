package com.LTI.ColProHib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Student {
	
	@Id
	@Column(name="stuId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myseq")
	@SequenceGenerator(name="myseq",sequenceName="mysequence",allocationSize=1)
	private int stuid;
	
	
	private String studname;
	
	
	private Date studdob; 
	
	
	private Course c;
	
	
	private Department d;
		
	
	public Student() {}


	public int getStuid() {
		return stuid;
	}


	public void setStuid(int stuid) {
		this.stuid = stuid;
	}


	public String getStudname() {
		return studname;
	}


	public void setStudname(String studname) {
		this.studname = studname;
	}


	public Date getStuddob() {
		return studdob;
	}


	public void setStuddob(Date studdob) {
		this.studdob = studdob;
	}


	public Course getC() {
		return c;
	}


	public void setC(Course c) {
		this.c = c;
	}


	public Department getD() {
		return d;
	}


	public void setD(Department d) {
		this.d = d;
	}


	public Student(int stuid, String studname, Date studdob, Course c, Department d) {
		super();
		this.stuid = stuid;
		this.studname = studname;
		this.studdob = studdob;
		this.c = c;
		this.d = d;
	}


	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", studname=" + studname + ", studdob=" + studdob + ", c=" + c + ", d=" + d
				+ "]";
	}
	
	
	
	
	
}
