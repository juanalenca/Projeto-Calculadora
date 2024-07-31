package br.com.cod3r.calc.vision;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {
	
	public Button(String text, Color color) {
		setText(text);
		setFont(new Font("courier", Font.PLAIN, 25));
		setOpaque(true);
		setBackground(color);
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
