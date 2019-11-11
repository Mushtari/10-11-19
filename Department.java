package com.LTI.ColProHib;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Department {
	
	@Id
	@Column(name="deptId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myseq")
	@SequenceGenerator(name="myseq",sequenceName="mysequence",allocationSize=1)
	private int id;
	
	@Column(name="deptName")
	private String name;
	
	@Column(name="deptLoc")
	private String location;
	
	@OneToMany(mappedBy="dept")
	private Set<Course> cp = new HashSet<Course>();
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	

}
