package br.com.cod3r.calc.model;

public class Memory {
	
	private static final Memory instance = new Memory();
	private String textActual = "";


	private Memory() {
		
	}
	
	public static Memory getInstace() {
		return instance;
	}
	
	public String getTextActual() {
		return textActual.isEmpty() ? "0" : textActual;
	}


}
