package de.kleeraphie.lib.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1204973575647104225L;
	int years;
	
	public GUI(int years) {
		this.years = years;
		
		createWindow();
	}
	
	private void createWindow() {
		setTitle("Life in Blocks");
		
		requestFocus();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(689, 1040); 
		setResizable(false);
		
		
		setContentPane(createContent());
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private JPanel createContent() {
		JPanel content;
		
		content = new JPanel(new GridLayout(years, 53));
		
		for (int y = 0; y < years; y++) {
			for (int w = 0; w < 53; w++) {
				
				JButton week = new JButton();
				
				week.setPreferredSize(new Dimension(5, 5));
				
				week.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

				content.add(week);
				
			}
		}
		
//		JScrollPane scrollPanel = new JScrollPane(content);
//		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
////      scrollPane.setBounds(0, 0, 300, 200); TODO: nötig?
//		scrollPanel.setPreferredSize(new Dimension(600, 1040)); // TODO: Tabelle soll bis nach ganz unten gehen
//		
//		scrollPanel.setBorder(BorderFactory.createEmptyBorder());
		
//		setContentPane(scrollPanel);
		
//		setContentPane(content);
		return content;
	}

}
