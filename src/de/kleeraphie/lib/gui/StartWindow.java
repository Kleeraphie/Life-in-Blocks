package de.kleeraphie.lib.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class StartWindow extends JFrame {
	private static final long serialVersionUID = 365730017473471771L;
	private GridBagConstraints c;
	JPanel content;
	
	public StartWindow() {
		
		c = new GridBagConstraints();
		
		createWindow();
		
		add(createStartPanel(), BorderLayout.CENTER);
		buildButtons();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void createWindow() {
		setTitle("Life in Blocks");

		requestFocus();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(689, 1040);
		setResizable(false);
		setLayout(new BorderLayout());
		
	}
	
	private JScrollPane createStartPanel() {
		JScrollPane scrollPanel;

		content = new JPanel(new GridBagLayout());

		scrollPanel = new JScrollPane(content);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setPreferredSize(new Dimension(600, 1040));

		c.gridx = 0;
		c.gridy = 0;
		c.insets.bottom = 20;
		c.insets.top = 20;
		
		content.add(createCell(), c);

		c.insets.top = 0;
		
		return scrollPanel;
	}

	private JPanel createCell() {
		JPanel cell;
		GridBagConstraints cellC;
		JLabel nameStr, colorStr, startDateStr, endDateStr;
		JTextField name;
		JButton colorBtn;
		// JDatePicker

		cell = new JPanel();
		cell.setLayout(new GridBagLayout());
		cell.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		cellC = new GridBagConstraints();

		nameStr = new JLabel("Text:");
		colorStr = new JLabel("Farbe:");
		startDateStr = new JLabel("Beginn:");
		endDateStr = new JLabel("Ende:");

		cellC.gridx = 0;
		cellC.gridy = 0;

		cell.add(nameStr, cellC);

		cellC.anchor = GridBagConstraints.LINE_END;
		cellC.insets = new Insets(10, 10, 10, 10);

		cellC.gridy++;
		cell.add(colorStr, cellC);

		cellC.gridy++;
		cell.add(startDateStr, cellC);

		cellC.gridy++;
		cell.add(endDateStr, cellC);

		cellC.gridx = 1;
		cellC.gridy = 0;
		cellC.insets.left = 20;

		name = new JTextField(24);

		cell.add(name, cellC);

		colorBtn = new JButton();
		colorBtn.setPreferredSize(new Dimension(25, 25));
		colorBtn.setBackground(Color.WHITE); // Weiß sieht für den Nutzer nach null aus
		colorBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new JColorChooser();
				Color color = JColorChooser.showDialog(null, "Farbauswahl", null);

				colorBtn.setBackground(color);

			}
		});

		cellC.gridy++;
		cellC.anchor = GridBagConstraints.LINE_START;
		cell.add(colorBtn, cellC);

		JDatePickerImpl startDatePicker = createJDatePicker();

		cellC.gridy++;
		cellC.anchor = GridBagConstraints.LINE_END;
		cell.add(startDatePicker, cellC);

		JDatePickerImpl endDatePicker = createJDatePicker();
		// TODO: endDate must be greater than startDate

		cellC.gridy++;
		cell.add(endDatePicker, cellC);

		return cell;
	}
	
	private JDatePickerImpl createJDatePicker() {
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		
		return datePicker;
	}

	private void buildButtons() {
		JPanel btnPanel;
		GridBagConstraints btnC;
		JButton addCellBtn, finish;

		btnC = new GridBagConstraints();

		btnC.gridx = 0;
		btnC.insets = new Insets(10, 5, 10, 5);

		btnPanel = new JPanel();
		btnPanel.setLayout(new GridBagLayout());

		addCellBtn = new JButton("Neuen Eintrag hinzufügen");
		addCellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel cell = createCell();

				c.gridy++;
				content.add(cell, c);

				revalidate();
			}
		});

		btnPanel.add(addCellBtn, btnC);
		
		finish = new JButton("Weiter");
		
		btnC.gridx++;
		btnPanel.add(finish, btnC);

		add(btnPanel, BorderLayout.SOUTH);
	}

}
