package com.nagal.splitwise.models.expense;

import com.nagal.splitwise.models.User;
import com.nagal.splitwise.models.split.ExactSplit;
import com.nagal.splitwise.models.split.Split;

import java.util.List;

public class ExactExpense extends Expense {

	public ExactExpense(double amount, User paidBy, List<Split> splits) {
		super(amount, paidBy, splits);
	}

	@Override
	public boolean validate() {
		for(Split split:getSplits()){
			if(!(split instanceof ExactSplit)){
				return  false;
			}
		}
		double totalAmount=getAmount();
		double sumAmount=0;

		for(Split split:getSplits()){
			ExactSplit exactSplit=(ExactSplit) split;
			sumAmount+=exactSplit.getAmount();
		}

		if(totalAmount!=sumAmount){
			return false;
		}
		return true;
	}

}
