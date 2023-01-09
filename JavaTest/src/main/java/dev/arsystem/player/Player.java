package dev.arsystem.player;

public class Player {
	
	public Player(Dice dice, int minToWin) {
		this.dice = dice;
		this.minToWin = minToWin;
	}
	
	public boolean play() {
		return dice.roll() >= minToWin;
	}
	
	private Dice dice;
	
	private int minToWin;
}
