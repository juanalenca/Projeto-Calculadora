package br.com.cod3r.calc.vision;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.cod3r.calc.model.Memory;
import br.com.cod3r.calc.model.MemoryObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoryObserver {
	
	private final JLabel label;
	
	public Display() {
		
		Memory.getInstace().addObserver(this);
		
		setBackground(new Color(32, 32, 32));
		label = new JLabel(Memory.getInstace().getTextActual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 35));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(label);
	}

	@Override
	public void changedValue(String newValue) {
		label.setText(newValue);
	}

}
