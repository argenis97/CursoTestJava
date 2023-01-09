package dev.arsystem.player;

import java.util.Random;

public class Dice {
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	public int roll() {
		return new Random().nextInt(sides) + 1;
	}
	
	private int sides;
}
