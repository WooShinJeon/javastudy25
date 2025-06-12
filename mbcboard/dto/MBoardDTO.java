package mbcboard.dto;

import java.sql.Date;

public class MBoardDTO {
	
	private int mbno;
	private String mbtitle;
	private String mbcontent;
	private String mbwriter;
	private Date mbdate;
	private String mbid;
	
	
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
	public Date getMbdate() {
		return mbdate;
	}
	public String getMbid() {
		return mbid;
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
	public void setMbdate(Date mbdate) {
		this.mbdate = mbdate;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	
	
}
