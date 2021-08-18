package com.nagal.splitwise.service;

import com.nagal.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

import java.awt.desktop.SystemEventListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class TTTService {
	private List <List<Character>> location;
	private int size;
	private int moveNumber;
	private User user1,user2;

	public TTTService(int size,String userA,String userB) {
		this.location = new ArrayList <List <Character> >(size);
		this.size = size;
		this.moveNumber=1;
		this.user1=new User(userA,'X');
		this.user2=new User(userB,'O');

		for(int i=0;i<size;i++) {
			ArrayList<Character> temp= new ArrayList<>(size);
			for(int j=0;j<size;j++){
				temp.add('-');
			}
			location.add(temp);
		}
	}

	public void printGame(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++) {
				System.out.printf("%c ",location.get(i).get(j));
			}
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}

	public Boolean validMove(int x,int y){
		if(x<1 || x>size || y<1 || y>size) return false;
		if(location.get(x-1).get(y-1)=='O' || location.get(x-1).get(y-1)=='X') return false;
		return true;
	}

	public void playMove(int x,int y){
		if(!validMove(x,y)) {
			System.out.printf("Your input %d  %d was invalid please re enter valid choice to play \n", x, y);
			return;
		}
		System.out.printf("move is %d\n",moveNumber);
		if(moveNumber%2==0) location.get(x-1).set(y-1,'O');
		else location.get(x-1).set(y-1,'X');
		moveNumber++;
		return;
	}


	public String isFinished(){

		int countD1=0; // +1 for X , -1 for O;
		int countD2=0; // +1 for X , -1 for O;

		for(int i=0;i<size;i++){
			int countO=0;
			int countX=0;
			int columnO=0;
			int columnX=0;

			for(int j=0;j<size;j++) {
				char ch=location.get(i).get(j);
				char chColumn=location.get(j).get(i);

				if(ch=='O') countO++;
				else if(ch=='X') countX++;

				if(chColumn=='O') columnO++;
				else if(chColumn=='X') columnX++;

				if(i==j){
					if(ch=='O') countD1--;
					if(ch=='X') countD1++;
				}

				if(i+j==size+1) {
					if (ch == 'O') countD2--;
					if (ch == 'X') countD2++;
				}
			}

			if(countX==size || countD2==size || countD1==size || columnX==size){
				System.out.printf("won by %s \n",user1.getUsername());
				return user1.getUsername();
			}
			if(columnO==size || countO==size || countD2==-1*size || countD1==-1*size ) {
				System.out.printf("won by %s \n",user2.getUsername());
				return user2.getUsername();
			}
		}
	return null;
	}

}
