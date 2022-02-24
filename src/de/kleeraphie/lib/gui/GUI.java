package de.kleeraphie.lib.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class GUI {
	private static final long serialVersionUID = 1204973575647104225L;
	private int years;
	private GridBagConstraints c;
	JPanel content;

	public GUI(int years) {
		this.years = years;
		c = new GridBagConstraints();

//		createWindow();
		new StartWindow();
	}

//	private void createWindow() {
//		setTitle("Life in Blocks");
//
//		requestFocus();
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(689, 1040);
////		setResizable(false);
//		setLayout(new BorderLayout());
//
////		setContentPane(createContent());
//		
//
//		setLocationRelativeTo(null);
//		setVisible(true);
//	}

	private JPanel createContent() {

		content = new JPanel(new GridLayout(years, 53));

		for (int y = 0; y < years; y++) {
			for (int w = 0; w < 53; w++) {

				JButton week = new JButton();

				week.setPreferredSize(new Dimension(5, 5));

				week.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

				content.add(week);

			}
		}

		return content;
	}

}
