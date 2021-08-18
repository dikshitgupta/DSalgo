package com.nagal.splitwise.models.expense;

import com.nagal.splitwise.models.User;
import com.nagal.splitwise.models.split.PercentSplit;
import com.nagal.splitwise.models.split.Split;

import java.util.List;

public class PercentExpense extends Expense{
	public PercentExpense(double amount, User paidBy, List<Split> splits) {
		super(amount, paidBy, splits);
	}

	public boolean validate(){
		for(Split split:getSplits()){
			if(!(split instanceof PercentSplit)){
				return false;
			}
		}

		double totalPercent=100;
		double sumPercent=0;

		for(Split split: getSplits()){
			PercentSplit percentSplit= (PercentSplit) split;
			sumPercent+=percentSplit.getPercent();
		}

		if(sumPercent!=totalPercent){
			return false;
		}
		return true;
	}

}

