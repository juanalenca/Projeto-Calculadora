package br.com.cod3r.calc.vision;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	public Calculator() {
		
		organizarLayout();
		
		setSize(335, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233, 75));
		add(display, BorderLayout.NORTH);
		
		Keyboard keyBoard = new Keyboard();
		add(keyBoard, BorderLayout.CENTER);
	}


	public static void main(String[] args) {
		
		new Calculator();
		
	}
	
	
}
