package junetest.dto;

import java.sql.Date;

public class MemberDTO {
	
	private int mno;
	private String mname;
	private String mid;
	private String mpw;
	private String mphone;
	private String memail;
	private Date mdate;
	
	
	public int getMno() {
		return mno;
	}
	public String getMname() {
		return mname;
	}
	public String getMid() {
		return mid;
	}
	public String getMpw() {
		return mpw;
	}
	public String getMphone() {
		return mphone;
	}
	public String getMemail() {
		return memail;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
}
