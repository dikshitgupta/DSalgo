package com.nagal.splitwise;


import com.nagal.splitwise.models.User;
import com.nagal.splitwise.models.expense.ExpenseType;
import com.nagal.splitwise.models.split.EqualSplit;
import com.nagal.splitwise.models.split.ExactSplit;
import com.nagal.splitwise.models.split.PercentSplit;
import com.nagal.splitwise.models.split.Split;
import com.nagal.splitwise.service.ExpenseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseApplication {

	public static void main(String[] args) {

		ExpenseManager expenseManager=new ExpenseManager();

		expenseManager.addUser(new User("U1","dikshit","dikshit@gmail.com","898989"));
		expenseManager.addUser(new User("U2","rishi","rishi@barkha.com","666666"));
		expenseManager.addUser(new User("U3","panda","panda@fmail.com","111111"));

		Scanner scanner=new Scanner(System.in);

		while(true){

			String command=scanner.nextLine();
			String[] commands=command.split(" ");
			String commandType=commands[0];

			switch (commandType) {
				case "SHOW":
					if (commands.length == 1) {
						expenseManager.showBalances();
					} else {
						expenseManager.showBalance(commands[1]);
					}
					break;

				case "EXPENSE":
					String paidBy = commands[1];
					Double amount = Double.parseDouble(commands[2]);
					int noOfUsers = Integer.parseInt(commands[3]);
					String expenseType = commands[4 + noOfUsers];
					List<Split> splits = new ArrayList<Split>();

					switch (expenseType) {

						case "EQUAL":
							System.out.printf("equal case of expense");
							for (int i = 0; i < noOfUsers; i++) {
								splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
							}
							expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits);
							break;
						case "EXACT":
							for (int i = 0; i < noOfUsers; i++) {
								splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
							}
							expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits);
							break;
						case "PERCENT":
							for (int i = 0; i < noOfUsers; i++) {
								splits.add(new PercentSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
							}
							expenseManager.addExpense(ExpenseType.PERCENT, amount, paidBy, splits);
							break;
					}

					break;
				}
		}
	}
}
