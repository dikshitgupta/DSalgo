package com.nagal.splitwise.service;
import com.nagal.splitwise.models.User;
import com.nagal.splitwise.models.expense.*;
import com.nagal.splitwise.models.split.PercentSplit;
import com.nagal.splitwise.models.split.Split;

import java.util.List;


public class ExpenseService {

	public static Expense createExpense(ExpenseType expenseType, double amount, User paidby, List<Split> splits){
		switch (expenseType){
			case EXACT:
				System.out.printf("Exact expense ");
				return new ExactExpense(amount,paidby,splits);
			case PERCENT:
				System.out.printf("Percent expense");
				for(Split split:splits){
					PercentSplit percentSplit=(PercentSplit) split;
					split.setAmount(amount*percentSplit.getPercent()/100);
				}
				return new PercentExpense(amount,paidby,splits);
			case EQUAL:
				int totalSplits=splits.size();
				double splitAmount= ((double) Math.round(amount/totalSplits));
				for(Split split:splits){
					split.setAmount(splitAmount);
				}
				splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
				return new EqualExpense(amount,paidby,splits);
			default:
				return null;
		}

	}
}
