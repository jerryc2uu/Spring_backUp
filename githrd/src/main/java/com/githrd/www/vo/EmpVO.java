package com.githrd.www.vo;

import java.text.SimpleDateFormat;
import java.util.*;

public class EmpVO {
	private int eno, dno, mgr, sal, grade;
	private String name, job, sangsa, comm, dname, loc, sdate, sel;
	private Date hiredate;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSangsa() {
		return sangsa;
	}
	public void setSangsa(String sangsa) {
		this.sangsa = sangsa;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdate = form.format(hiredate);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
		setSdate();
	}
	public String getSel() {
		return sel;
	}
	public void setSel(String sel) {
		this.sel = sel;
	}
	@Override
	public String toString() {
		return "EmpVO [eno=" + eno + ", dno=" + dno + ", mgr=" + mgr + ", sal=" + sal + ", grade=" + grade + ", name="
				+ name + ", job=" + job + ", sangsa=" + sangsa + ", comm=" + comm + ", dname=" + dname + ", loc=" + loc
				+ ", sdate=" + sdate + ", sel=" + sel + ", hiredate=" + hiredate + "]";
	}
	
	
	
}
