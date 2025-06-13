package junetest.dto;

import java.sql.Date;

public class MBoardDTO {
	
	
	private int mbno;
	private String mbtitle;
	private String mbcontent;
	private String mbwriter;
	private String mbid;
	private Date mbdate;
	
	
	public int getMbno() {
		return mbno;
	}
	public String getMbtitle() {
		return mbtitle;
	}
	public String getMbcontent() {
		return mbcontent;
	}
	public String getMbwriter() {
		return mbwriter;
	}
	public String getMbid() {
		return mbid;
	}
	public Date getMbdate() {
		return mbdate;
	}
	public void setMbno(int mbno) {
		this.mbno = mbno;
	}
	public void setMbtitle(String mbtitle) {
		this.mbtitle = mbtitle;
	}
	public void setMbcontent(String mbcontent) {
		this.mbcontent = mbcontent;
	}
	public void setMbwriter(String mbwriter) {
		this.mbwriter = mbwriter;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	public void setMbdate(Date mbdate) {
		this.mbdate = mbdate;
	}
	
	
	
}
