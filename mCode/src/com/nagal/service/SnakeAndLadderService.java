package com.nagal.service;

import com.nagal.models.Ladder;
import com.nagal.models.Player;
import com.nagal.models.Snake;
import com.nagal.models.SnakeAndLadderboard;

import java.util.*;

public class SnakeAndLadderService {
	private SnakeAndLadderboard snakeandLadderboard;
	private int playerCount;
	private Queue<Player> players;
	private Boolean isGameCompleted;

	private int noOfDices;
	private Boolean continueTillLastPlayer;

	private static final int DEFAULT_BOARD_SIZE=100;
	private static final int DEFAULT_DICES=1;

	public SnakeAndLadderService(int boardsize){
		this.snakeandLadderboard=new SnakeAndLadderboard(boardsize);
		this.players=new LinkedList<Player>();
	}

	public SnakeAndLadderService(){
		this.snakeandLadderboard=new SnakeAndLadderboard(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
	}

	public void setContinueTillLastPlayer(Boolean continueTillLastPlayer) {
		this.continueTillLastPlayer = continueTillLastPlayer;
	}

	public void setNoOfDices(int noOfDices) {
		this.noOfDices = noOfDices;
	}

	public void setPlayers(List<Player> players) {
		this.players = new LinkedList<Player>();
		this.playerCount=players.size();
		Map<String,Integer> playerPieces=new HashMap<String,Integer>();
		for (Player player : players){
			this.players.add(player);
			playerPieces.put(player.getId(),0);
		}
		snakeandLadderboard.setPlayerPieces(playerPieces);
	}

	public void setSnakes(List<Snake> snakes){
		snakeandLadderboard.setSnakes(snakes);
	}

	public void setLadders(List<Ladder> ladders){
		snakeandLadderboard.setLadders(ladders);
	}

	int getNewPositionAfterSnakesAndLadders(int position){
		int prev;
		do{
			prev=position;
			for(Snake snake : snakeandLadderboard.getSnakes()) {
				if(snake.getStart()==prev){
				position=snake.getEnd();
				}
			}

			for(Ladder ladder : snakeandLadderboard.getLadders()) {
				if(ladder.getStart()==prev){
					position=ladder.getEnd();
				}
			}
		}
		while(prev!=position);
		return position;
	}

	public void movePlayer(Player player,int positions){
		int oldPosition=snakeandLadderboard.getPlayerPieces().get(player.getId());
		int newPosition=oldPosition + positions;

		int boardSize=snakeandLadderboard.getSize();
		if(newPosition>oldPosition){
			newPosition=oldPosition;
		}
		else newPosition=getNewPositionAfterSnakesAndLadders(newPosition);

		snakeandLadderboard.getPlayerPieces().put(player.getId(),newPosition);
	}

	private Boolean hasPlayerWon(Player player){
		int position=snakeandLadderboard.getPlayerPieces().get(player.getId());
		return position==snakeandLadderboard.getSize();
	}

	private Boolean isGameCompleted(){
		int currentNumberOfPlayers=players.size();
		return currentNumberOfPlayers < playerCount;
	}

	public void startGame(){
		while(!isGameCompleted()){
			Player currentPlayer=players.poll();
			int diceValue= DiceService.roll();
			if(hasPlayerWon(currentPlayer)){
				System.out.println(currentPlayer.getName() + "won the game");
				snakeandLadderboard.getPlayerPieces().remove(currentPlayer.getId());
			}
			else{
				players.add(currentPlayer);
			}
		}
	}
}
