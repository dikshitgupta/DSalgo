package com.nagal.design.designPatterns.abstractFactory;

//In java <T> means Generic class. A Generic Class is a class which can work on any type of data type or in other words we can say it is data type independent.

public interface AbstractFactory<T>{
	T create(String type);
}

