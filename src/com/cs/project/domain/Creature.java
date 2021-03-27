package com.cs.project.domain;

public class Creature implements IAttack {
	private String name;
	private int hp; // health points
	private int power; // attack power
	private int position; // position

	public Creature() {

	}

	public Creature(String name, int hp, int power, int position) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Creature [name=" + name + ", hp=" + hp + ", power=" + power + ", position=" + position + "]";
	}

	@Override
	public void attack(Creature c1, Creature c2) {
		c2.setHp(c2.getHp() - c1.getPower());

	}

}
