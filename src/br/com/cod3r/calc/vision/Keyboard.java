package br.com.cod3r.calc.vision;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.cod3r.calc.model.Memory;

@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener {
	
	private final Color COLOR_GRAY_DARK = new Color(68, 68, 68);
	private final Color COLOR_GRAY_LIGHT = new Color(99, 99, 99);
	private final Color COLOR_BLUE = new Color(15, 97, 130);	
	
	
	
	public Keyboard() {
	
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		//ocupa o eixo x e y completamente
		c.weightx = 1;
		c.weighty = 1;
		
		//Organiza os botões
		c.fill = GridBagConstraints.BOTH;
		
		//Line 1
		c.gridwidth = 2;
		addButton("AC", COLOR_GRAY_DARK, c, 0, 0);
		c.gridwidth = 1;
		addButton("±", COLOR_GRAY_DARK, c, 2, 0);
		addButton("/", COLOR_BLUE, c, 3, 0);
		
		//Line 2
		addButton("7", COLOR_GRAY_LIGHT, c, 0, 1);
		addButton("8", COLOR_GRAY_LIGHT, c, 1, 1);
		addButton("9", COLOR_GRAY_LIGHT, c, 2, 1);
		addButton("x", COLOR_BLUE, c, 3, 1);
		
		//Line 3
		addButton("4", COLOR_GRAY_LIGHT, c, 0, 2);
		addButton("5", COLOR_GRAY_LIGHT, c, 1, 2);
		addButton("6", COLOR_GRAY_LIGHT, c, 2, 2);
		addButton("-", COLOR_BLUE, c, 3, 2);
		
		//Line 4
		addButton("1", COLOR_GRAY_LIGHT, c, 0, 3);
		addButton("2", COLOR_GRAY_LIGHT, c, 1, 3);
		addButton("3", COLOR_GRAY_LIGHT, c, 2, 3);
		addButton("+", COLOR_BLUE, c, 3, 3);
		
		//Line 5
		c.gridwidth = 2;
		addButton("0", COLOR_GRAY_LIGHT, c, 0, 4);
		c.gridwidth = 1;
		addButton(",", COLOR_GRAY_LIGHT, c, 2, 4);
		addButton("=", COLOR_BLUE, c, 3, 4);
		
		
		
	}



	private void addButton(String text, Color color, 
			GridBagConstraints c, int x, int y) {
		
		c.gridx = x;
		c.gridy = y;
		Button button = new Button(text, color);
		button.addActionListener(this);
		add(button, c);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			Memory.getInstace().processCommand(button.getText());
		}
	}
	
	
	
	

}
