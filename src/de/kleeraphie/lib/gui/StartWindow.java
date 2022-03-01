package de.kleeraphie.lib.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import de.kleeraphie.lib.storage.Life;
import de.kleeraphie.lib.storage.Section;
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

		buildStartPanel();
	}

	private void buildStartPanel() {
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

		content.add(createDataCell(), c);

		c.gridy++;
		content.add(createSectionCell(), c);

		c.insets.top = 0;

		add(scrollPanel, BorderLayout.CENTER);
	}

	private JPanel createDataCell() {
		JPanel cell;
		GridBagConstraints cellC;
		JLabel titleStr, birthDateStr, ageStr;
		JTextField title;
		JFormattedTextField age;
		JDatePickerImpl birthDatePicker;

		cell = new JPanel();
		cell.setLayout(new GridBagLayout());
		cell.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		cellC = new GridBagConstraints();

		titleStr = new JLabel("Text:");

		cellC.gridx = 0;
		cellC.gridy = 0;
		cellC.insets = new Insets(10, 10, 10, 10);

		cell.add(titleStr, cellC);

		birthDateStr = new JLabel("Geburtsdatum:");

		cellC.gridy++;
		cell.add(birthDateStr, cellC);

		ageStr = new JLabel("Alter:");

		cellC.gridy++;
		cell.add(ageStr, cellC);

		cellC.anchor = GridBagConstraints.LINE_END;

		cellC.gridx = 1;
		cellC.gridy = 0;
		cellC.insets.left = 20;

		title = new JTextField(24);

		cell.add(title, cellC);

		birthDatePicker = createJDatePicker();

		cellC.gridy++;
		cell.add(birthDatePicker, cellC);

		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setAllowsInvalid(false);
		age = new JFormattedTextField(formatter);
		age.setColumns(3);
		
		cellC.anchor = GridBagConstraints.LINE_START;
		cellC.gridy++;
		cell.add(age, cellC);

		return cell;
	}

	private JPanel createSectionCell() {
		JPanel cell;
		GridBagConstraints cellC;
		JLabel nameStr, colorStr, startDateStr, endDateStr;
		JTextField name;
		JButton colorBtn;
		JDatePickerImpl startDatePicker, endDatePicker;

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

		startDatePicker = createJDatePicker();

		cellC.gridy++;
		cellC.anchor = GridBagConstraints.LINE_END;
		cell.add(startDatePicker, cellC);

		endDatePicker = createJDatePicker();
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
				JPanel cell = createSectionCell();

				c.gridy++;
				content.add(cell, c);

				revalidate();
			}
		});

		btnPanel.add(addCellBtn, btnC);

		finish = new JButton("Weiter");
		finish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});

		btnC.gridx++;
		btnPanel.add(finish, btnC);

		add(btnPanel, BorderLayout.SOUTH);
	}

	private void finish() {
		BorderLayout layout = (BorderLayout) getContentPane().getLayout();
		JScrollPane scrollPanel = (JScrollPane) layout.getLayoutComponent(BorderLayout.CENTER);
		JPanel contentFrame = (JPanel) scrollPanel.getViewport().getView();
		Section[] sections = new Section[contentFrame.getComponentCount() - 1];

		// get general information of life
		JPanel dataCell = (JPanel) contentFrame.getComponent(0);
		String title = ((JTextField) dataCell.getComponent(3)).getText();
		LocalDate birthDate = getLocalDateFromDatePicker((JDatePickerImpl) dataCell.getComponent(4));
		int age = Integer.parseInt(((JTextField) dataCell.getComponent(5)).getText());

		// get information of sections
		for (int cellIndex = 1; cellIndex < contentFrame.getComponentCount(); cellIndex++) {

			JPanel cell = (JPanel) contentFrame.getComponent(cellIndex);
			String name = ((JTextField) cell.getComponent(4)).getText();
			Color color = ((JButton) cell.getComponent(5)).getBackground();
			LocalDate startDate = getLocalDateFromDatePicker((JDatePickerImpl) cell.getComponent(6));
			LocalDate endDate = getLocalDateFromDatePicker((JDatePickerImpl) cell.getComponent(7));

			Section s = new Section(name, color, startDate, endDate);

			sections[cellIndex - 1] = s;

		}

		Life l = new Life(age, title, birthDate, sections);
		
		System.out.println(l.toString());

	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private LocalDate getLocalDateFromDatePicker(JDatePickerImpl datePicker) {
		Date date = (Date) datePicker.getJDateInstantPanel().getModel().getValue();

		return convertToLocalDateViaInstant(date);
	}

}
