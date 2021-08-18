package com.nagal.Snake.Game.service;

import com.nagal.Snake.Game.models.Snake;
import com.nagal.Snake.Game.models.Ladder;
import com.nagal.Snake.Game.models.Player;
import com.nagal.Snake.Game.models.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {

	private SnakeAndLadderBoard snakeAndLadderBoard;
	private int playerCount;
	private Queue<Player> players;
	private Boolean isGameCompleted;

	private int noOfDices;
	private Boolean continueTillLastPlayer;

	private static final int DEFAULT_BOARD_SIZE=100;
	private static final int DEFAULT_DICES=1;

	public SnakeAndLadderService(int boardSize){
		this.snakeAndLadderBoard=new SnakeAndLadderBoard(boardSize);
		this.players=new LinkedList<Player>();
	}

	public SnakeAndLadderService(){
		this.snakeAndLadderBoard=new SnakeAndLadderBoard(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
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
		snakeAndLadderBoard.setPlayerPieces(playerPieces);
	}

	public void setSnakes(List<Snake> snakes){
		snakeAndLadderBoard.setSnakes(snakes);
	}

	public void setLadders(List<Ladder> ladders){
		snakeAndLadderBoard.setLadders(ladders);
	}

	int getNewPositionAfterSnakesAndLadders(int position){
		int prev;
		do{
			prev=position;
			for(Snake snake : snakeAndLadderBoard.getSnakes()) {
				if(snake.getStart()==prev){
					position=snake.getEnd();
				}
			}

			for(Ladder ladder : snakeAndLadderBoard.getLadders()) {
				if(ladder.getStart()==prev){
					position=ladder.getEnd();
				}
			}
		}
		while(prev!=position);
		return position;
	}

	public void movePlayer(Player player,int positions){
		int oldPosition=snakeAndLadderBoard.getPlayerPieces().get(player.getId());
		int newPosition=oldPosition + positions;

//		System.out.printf("Moving player %s",player.getName());

		int boardSize=snakeAndLadderBoard.getSize();
		if(newPosition>snakeAndLadderBoard.getSize()){
			newPosition=oldPosition;
		}
		else
		newPosition=getNewPositionAfterSnakesAndLadders(newPosition);

		snakeAndLadderBoard.getPlayerPieces().put(player.getId(),newPosition);
	}

	private Boolean hasPlayerWon(Player player){
		int position=snakeAndLadderBoard.getPlayerPieces().get(player.getId());
		System.out.printf("    pos: %d \n",position);
		return position==snakeAndLadderBoard.getSize();
	}

	private Boolean isGameCompleted(){
		int currentNumberOfPlayers=players.size();
		return currentNumberOfPlayers < playerCount;
	}

	public void startGame(){
		while(!isGameCompleted()){
			Player currentPlayer=players.poll();
			int diceValue= DiceService.roll();

			System.out.printf("%s: %d ",currentPlayer.getName(),diceValue);
			movePlayer(currentPlayer,diceValue);

			if(hasPlayerWon(currentPlayer)){
				System.out.println(currentPlayer.getName() + "won the game");
				snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
			}
			else{
				players.add(currentPlayer);
			}

		}
	}

}
