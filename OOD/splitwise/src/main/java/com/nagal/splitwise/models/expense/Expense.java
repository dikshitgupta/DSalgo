package com.nagal.splitwise.models.expense;

import com.nagal.splitwise.models.User;
import com.nagal.splitwise.models.split.Split;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class                                                                                                                                                                                                                                        Expense {

	private String id;
	private double amount;
	private User paidBy;
	private List<Split> splits;
	public abstract boolean validate();

	public Expense(double amount, User paidBy, List<Split> splits) {
		this.amount = amount;
		this.paidBy = paidBy;
		this.splits = splits;
	}

}
