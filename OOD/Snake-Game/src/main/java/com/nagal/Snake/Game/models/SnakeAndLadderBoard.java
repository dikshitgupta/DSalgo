package com.nagal.Snake.Game.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {

	private int size;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	private Map< String,Integer > playerPieces;  // String is the name and Integer where that player is present.

	public SnakeAndLadderBoard(int size){
	this.size=size;
	this.snakes=new ArrayList<>();
	this.ladders=new ArrayList<>();
	this.playerPieces=new HashMap<>();  // id of a player and it's position in the board.
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public void setPlayerPieces(Map<String, Integer> playerPieces) {
		this.playerPieces = playerPieces;
	}

	public Map<String, Integer> getPlayerPieces() {
		return playerPieces;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public int getSize() {
		return size;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

}
