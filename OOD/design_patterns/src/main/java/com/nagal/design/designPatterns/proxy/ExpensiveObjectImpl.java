package com.nagal.design.designPatterns.proxy;

import static java.lang.Thread.sleep;

public class ExpensiveObjectImpl implements ExpensiveObject{

	public ExpensiveObjectImpl() {
		HeavyConfig();
	}

	@Override
	public void process(){
		System.out.println("processing complete.");
	}

	public void HeavyConfig(){
		System.out.println("Heavy config going ong.");
	}

}
