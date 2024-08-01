package br.com.cod3r.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
	private enum TypeCommand {
		RESET, INDICATION, NUMBER, DIV, MULT, SUB, SUM, EQUAL, COMMA;
	};
	
	
	private static final Memory instance = new Memory();
	
	
	private final List<MemoryObserver> observers = new ArrayList<>();
	
	
	private TypeCommand lastOperation = null;
	private boolean replace = false;
	private String textActual = "";
	private String textBuffer = "";


	private Memory() {
		
	}
	
	
	public static Memory getInstace() {
		return instance;
	}
	
	
	public void addObserver(MemoryObserver observer) {
		observers.add(observer);
	}
	
	
	public String getTextActual() {
		return textActual.isEmpty() ? "0" : textActual;
	}
	
	
	public void processCommand(String text) {
		
		TypeCommand typeCommand = toDetectTypeCommand(text);

		
		if(typeCommand == null) {
			return;
		} else if(typeCommand == TypeCommand.RESET) {
			textActual = "";
			textBuffer = "";
			replace = false;
			lastOperation = null;
		} else if(typeCommand == TypeCommand.INDICATION && textActual.contains("-")) {
			textActual = textActual.substring(1);
		} else if(typeCommand == TypeCommand.INDICATION && !textActual.contains("-")) {
			textActual = "-" + textActual;
		} else if(typeCommand == TypeCommand.NUMBER
				|| typeCommand == TypeCommand.COMMA) {
			textActual = replace ? text : textActual + text;
			replace = false;
		} else {
			replace = true;
			textActual = getResultOperation();
			textBuffer = textActual;
			lastOperation = typeCommand;
		}
		
		
		observers.forEach(o -> o.changedValue(getTextActual()));
	
	}


	private String getResultOperation() {
		
		if(lastOperation == null || lastOperation == TypeCommand.EQUAL) {
			return textActual;
		}
		
		double numberBuffer = 
				Double.parseDouble(textBuffer.replace(",", "."));
		double numberActual = 
				Double.parseDouble(textActual.replace(",", "."));
		
		double result = 0;
		
		if(lastOperation == TypeCommand.SUM) {
			result = numberBuffer + numberActual;
		} else if(lastOperation == TypeCommand.SUB) {
			result = numberBuffer - numberActual;
		} else if(lastOperation == TypeCommand.DIV) {
			result = numberBuffer / numberActual;
		} else if(lastOperation == TypeCommand.MULT) {
			result = numberBuffer * numberActual;
		}
		
		String text = Double.toString(result).replace(".", ",");
		
		boolean entire = text.endsWith(",0");
		
		return entire ? text.replace(",0", "") : text;
		
	}


	private TypeCommand toDetectTypeCommand(String text) {
		
		if(textActual.isEmpty() && text == "0") {
			return null;
		}
		
		try {
			
			Integer.parseInt(text);
			return TypeCommand.NUMBER;
			
		} catch (NumberFormatException e) {
			
			//Quando não for numero
			if("AC".equals(text)) {
				return TypeCommand.RESET;
			} else if("/".equals(text)) {
				return TypeCommand.DIV;
			} else if("x".equals(text)) {
			return TypeCommand.MULT;
			} else if("+".equals(text)) {
				return TypeCommand.SUM;
			} else if("-".equals(text)) {
				return TypeCommand.SUB;
			} else if("=".equals(text)) {
				return TypeCommand.EQUAL;
			} else if("±".equals(text)) {
				return TypeCommand.INDICATION;
			} else if(",".equals(text) 
					&& !textActual.contains(",")) {
				return TypeCommand.COMMA;
			}
		
		}
		
		return null;
	
	}


}
