package ch05.mbcbank.dto;

public class AccountDTO {
	private String ano;
	private String owner;
	private int balance;
	private String bankName;
	
	public AccountDTO(String ano, String owner, int balance, String bankName) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.bankName = bankName;
	}

	public AccountDTO() {
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
	
}
