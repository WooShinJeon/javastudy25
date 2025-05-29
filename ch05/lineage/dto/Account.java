package ch05.lineage.dto;

public class Account {
	
	private String id;
	private String pw;
	private String nickName;
	private String elfDTO;
	private String knightDTO;
	
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getNickName() {
		return nickName;
	}
	public String getElfDTO() {
		return elfDTO;
	}
	public String getKnightDTO() {
		return knightDTO;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setElfDTO(String elfDTO) {
		this.elfDTO = elfDTO;
	}
	public void setKnightDTO(String knightDTO) {
		this.knightDTO = knightDTO;
	}
	
}
