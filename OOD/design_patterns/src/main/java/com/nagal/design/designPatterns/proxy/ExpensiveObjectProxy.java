package com.nagal.design.designPatterns.proxy;

public class ExpensiveObjectProxy implements ExpensiveObject{

	private ExpensiveObject object;

	@Override
	public void process(){
		if(object==null){
			object=new ExpensiveObjectImpl();
		}
		object.process();
	}

	public ExpensiveObjectProxy() {
		this.object=null;
	}
}
