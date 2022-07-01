package com.githrd.www.vo;

import java.util.*;
import java.text.*;

public class SurveyVO {
	private int mno, ano, cnt, sino, sqno, svno, upno, total;
	private double per; 
	private String id, avatar, title, body, sdate; // body : 설문 문항 내용 & 설문 보기 내용
	private Date svdate;
	private List<SurveyVO> bogi;
	private int[] dap;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSino() {
		return sino;
	}
	public void setSino(int sino) {
		this.sino = sino;
	}
	public int getSqno() {
		return sqno;
	}
	public void setSqno(int sqno) {
		this.sqno = sqno;
	}
	public int getSvno() {
		return svno;
	}
	public void setSvno(int svno) {
		this.svno = svno;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getUpno() {
		return upno;
	}
	public void setUpno(int upno) {
		this.upno = upno;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdate = form.format(svdate);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getSvdate() {
		return svdate;
	}
	public void setSvdate(Date svdate) {
		this.svdate = svdate;
		setSdate();
	}
	
	public List<SurveyVO> getBogi() {
		return bogi;
	}
	public void setBogi(List<SurveyVO> bogi) {
		this.bogi = bogi;
	}
	public int[] getDap() {
		return dap;
	}
	public void setDap(int[] dap) {
		this.dap = dap;
	}
	@Override
	public String toString() {
		return "SurveyVO [mno=" + mno + ", ano=" + ano + ", cnt=" + cnt + ", sino=" + sino + ", sqno=" + sqno
				+ ", svno=" + svno + ", upno=" + upno + ", total=" + total + ", per=" + per + ", id=" + id + ", avatar="
				+ avatar + ", title=" + title + ", body=" + body + ", sdate=" + sdate + ", svdate=" + svdate + ", bogi="
				+ bogi + ", dap=" + Arrays.toString(dap) + "]";
	}
	
	
	
}
