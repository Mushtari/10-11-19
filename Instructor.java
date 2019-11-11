package com.LTI.ColProHib;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Instructor {

	
	@Id
	@Column(name="insId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myseq")
	@SequenceGenerator(name="myseq",sequenceName="mysequence",allocationSize=1)
	private int id;
		
	@Column(name="insName")
	private String name;
		
	@Column(name="insPh")
	private int phno;
	
	@Column(name="insRm")
	private int rmno;
	

	@Column(name="deptId")
	private Department d;
	
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPhno() {
		return phno;
	}


	public void setPhno(int phno) {
		this.phno = phno;
	}


	public int getRmno() {
		return rmno;
	}


	public void setRmno(int rmno) {
		this.rmno = rmno;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deptId")
	public Department getD() {
		return d;
	}


	public void setD(Department d) {
		this.d = d;
	}
	
	
	



}
