package com.nagal.splitwise;

import com.nagal.splitwise.service.TTTService;

import java.util.Arrays;
import java.util.Scanner;

public class TIcTacToeApplication {

	public static void main(String[] args) {

		TTTService tttService=new TTTService(3,"dikshit","kartik");

		Scanner scanner=new Scanner(System.in);

		while(tttService.isFinished()==null){
			String input=scanner.nextLine();
			String [] inputs=input.split(" ");
			tttService.playMove(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]));
			tttService.printGame();
		}

		int [] nums={1,2,3,4,5};

		@Override
		public int comparator(int a,int b){
			return a>b;
		}

		Arrays.sort(nums,comparator);

//		ArrayList<List<Character>> arr =new ArrayList<List<Character>>(3);
//		arr.size();
//
//		for(int i=0;i<3;i++) {
//			arr.add(new ArrayList<>(Arrays.asList('-','-','-')));
//		}
//
//		arr.get(0).set(1,'s');
//
//		System.out.printf("size of arraylist is %d \n", arr.size());
//		System.out.printf("size of idx 0 is %d \n", arr.get(0).size());
//
//		TTTService.printArl(arr);

	}
}
