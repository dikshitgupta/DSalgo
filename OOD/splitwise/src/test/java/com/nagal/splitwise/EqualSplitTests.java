//package com.nagal.splitwise;
//
//import com.nagal.splitwise.models.User;
//import com.nagal.splitwise.models.expense.ExpenseType;
//import com.nagal.splitwise.models.split.ExactSplit;
//import com.nagal.splitwise.models.split.Split;
//import com.nagal.splitwise.service.ExpenseManager;
//import org.junit.jupiter.api.Test;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class EqualSplitTests {
//
//	@Test
//	public void TestEqualSplit(){
//		User U1=new User("U1","Dikshit","dikshit@redditr.com","789563300");
//		User U2=new User("U2","Krish","krish@redditr.com","789563300");
//		User U3=new User("U3","Suchit","suchitredditr.com","789563300");
//
//		ExpenseManager expenseManager=new ExpenseManager();
//		expenseManager.addUser(U1);
//		expenseManager.addUser(U2);
//		expenseManager.addUser(U3);
//
//		Split split1=new ExactSplit(U1,100);
//		Split split2=new ExactSplit(U2,200);
//		Split split3=new ExactSplit(U3,300);
//		User paidby=U1;
//		expenseManager.addExpense(ExpenseType.EXACT,600,new ArrayList<Split>(Arrays.asList(split1,split2,split3));
//
//	}
//}
