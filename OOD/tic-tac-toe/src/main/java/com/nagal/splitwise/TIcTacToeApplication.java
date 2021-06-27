package com.nagal.splitwise;

import com.nagal.splitwise.service.TTTService;

import java.util.Arrays;
import java.util.Scanner;

public class TIcTacToeApplication {

	public static void main(String[] args) {

		TTTService tttService=new TTTService(3,"dikshit","kartik");

		Scanner scanner=new Scanner(System.in);
		tttService.printGame();
		while(tttService.isFinished()==null){
			String input=scanner.nextLine();
			String [] inputs=input.split(" ");
			tttService.playMove(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]));
			tttService.printGame();
		}

	}
}
