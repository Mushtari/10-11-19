package com.LTI.ColProHib;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Course {

		
		@Id
		@Column(name="couId")
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myseq")
		@SequenceGenerator(name="myseq",sequenceName="mysequence",allocationSize=1)
		private int couid;
		
		
		private String preq;
		
		
		private int dur;
		
		
		private String name;
		
		
		
		@ManyToOne(cascadeBy.ALL)
		private Department d;
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="insId")
		private Instructor i;
		
		
		public Course() {}


		public int getCouid() {
			return couid;
		}


		public void setCouid(int couid) {
			this.couid = couid;
		}


		public String getPreq() {
			return preq;
		}


		public void setPreq(String preq) {
			this.preq = preq;
		}


		public int getDur() {
			return dur;
		}


		public void setDur(int dur) {
			this.dur = dur;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Department getD() {
			return d;
		}


		public void setD(Department d) {
			this.d = d;
		}


		public Instructor getI() {
			return i;
		}


		public void setI(Instructor i) {
			this.i = i;
		}


		public Course(int couid, String preq, int dur, String name, Department d, Instructor i) {
			super();
			this.couid = couid;
			this.preq = preq;
			this.dur = dur;
			this.name = name;
			this.d = d;
			this.i = i;
		}


		@Override
		public String toString() {
			return "Course [couid=" + couid + ", preq=" + preq + ", dur=" + dur + ", name=" + name + ", d=" + d + ", i="
					+ i + "]";
		}
		
		
		
		
		
		
		
}		