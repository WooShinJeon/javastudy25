package ch05.lineage.dto;

public class HumanDTO {
	
	private String name;
	private String sex;
	private String level;
	private int hp;
	private int mp;
	private int money;
	
	
	
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getLevel() {
		return level;
	}
	public int getHp() {
		return hp;
	}
	public int getMp() {
		return mp;
	}
	public int getMoney() {
		return money;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public void setMoney(int money) {
		this.money = money;
	}

}
