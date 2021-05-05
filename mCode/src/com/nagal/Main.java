package com.nagal;

import com.nagal.models.Ladder;
import com.nagal.models.Player;
import com.nagal.models.Snake;
import com.nagal.service.SnakeAndLadderService;

import java.awt.geom.PathIterator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number of snakes and then their start end end point");
        int numberSnakes= scanner.nextInt();
        List <Snake> snakes= new ArrayList<Snake>();
        for(int i=0;i<numberSnakes;i++){
            snakes.add(new Snake(scanner.nextInt(),scanner.nextInt()));
        }

        System.out.println("Enter number of Ladders and then their start end end point");

        int numberLadders= scanner.nextInt();
        List <Ladder> ladders= new ArrayList<Ladder>();
        for(int i=0;i<numberLadders;i++){
            ladders.add(new Ladder(scanner.nextInt(),scanner.nextInt()));
        }

        int numberPlayer=scanner.nextInt();
        List <Player> players=new ArrayList<Player>();
        for(int i=0;i<numberPlayer;i++){
            players.add(new Player(Scanner.next()));
        }

        SnakeAndLadderService snakeAndLadderService=new SnakeAndLadderService();
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setPlayers(players);

        snakeAndLadderService.startGame();
    }
}
