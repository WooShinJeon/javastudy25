package ch04.marioKart.dto;

public class TireDTO {
	
	public String name;
	public double weight;
	public double speed;
	public double acceleration;
	public double handling;
	public double friction;
	
	
	
	public TireDTO(String name, double weight, double speed, double acceleration, double handling, double friction) {
		this.name = name;
		this.weight = weight;
		this.speed = speed;
		this.acceleration = acceleration;
		this.handling = handling;
		this.friction = friction;
	}

}
