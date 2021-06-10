package com.nagal.splitwise.models.split;

import com.nagal.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Split {
	private User user;
	double amount;

	public Split(User user) {
		this.user = user;
	}

}
