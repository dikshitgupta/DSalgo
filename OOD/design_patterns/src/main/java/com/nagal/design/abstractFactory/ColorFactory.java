package com.nagal.design.abstractFactory;

public class ColorFactory implements AbstractFactory <Color>{

		public Color create(String colorType){
			if(colorType.equalsIgnoreCase("BROWN")){
				return new Brown();
			}
			else if(colorType.equalsIgnoreCase("White")){
				return new White();
			}
			else return null;
		}

}
