package com.nagal.Snake.Game;

import com.nagal.Snake.Game.models.Snake;
import com.nagal.Snake.Game.models.Ladder;
import com.nagal.Snake.Game.models.Player;
import com.nagal.Snake.Game.service.SnakeAndLadderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class SnakeGameApplication {

	public static void main(String[] args) {

//		SpringApplication.run(SnakeGameApplication.class, args);
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of snakes and then their start end end point");
		int numberSnakes= scanner.nextInt();
		List<Snake> snakes= new ArrayList<Snake>();
		for(int i=0;i<numberSnakes;i++){
			snakes.add(new Snake(scanner.nextInt(),scanner.nextInt()));
		}

		System.out.println("Enter number of Ladders and then their start end end point");
		int numberLadders= scanner.nextInt();



		List <Ladder> ladders= new ArrayList<Ladder>();
		for(int i=0;i<numberLadders;i++){
			ladders.add(new Ladder(scanner.nextInt(),scanner.nextInt()));
		}


		System.out.println("Enter number of Players and their name");
		int numberPlayer=scanner.nextInt();
		List <Player> players=new ArrayList<Player>();
		for(int i=0;i<numberPlayer;i++){
			players.add(new Player(scanner.next()));
		}

		System.out.println("Game Created starting in 5 minutes");

		SnakeAndLadderService snakeAndLadderService=new SnakeAndLadderService();
		snakeAndLadderService.setLadders(ladders);
		snakeAndLadderService.setSnakes(snakes);
		snakeAndLadderService.setPlayers(players);
		snakeAndLadderService.startGame();
	}

}
