package com.cs.project.domain;

import java.util.List;

public class Hero extends Creature {

	private List<Creature> enemies; // enemies
	private int endPosition; // resource

	public Hero() {

	}

	public Hero(String name, int hp, int power, List<Creature> enemies, int position, int endPosition) {
		super(name, hp, power, position);
		this.enemies = enemies;
		this.endPosition = endPosition;
	}

	public List<Creature> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Creature> enemies) {
		this.enemies = enemies;
	}

	public int getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}

	@Override
	public String toString() {
		return "Hero [name=" + super.getName() + ", hp=" + super.getHp() + ", power=" + super.getPower() + ", enemies="
				+ enemies + ", endPosition=" + endPosition + ", position=" + super.getPosition() + "]";
	}

}
