package de.kleeraphie.lib.main;

import javax.swing.UIManager;

import de.kleeraphie.lib.gui.GUI;
import de.kleeraphie.lib.gui.StartWindow;

public class Main {

	public static void main(String[] args) {

		// Change LookAndFeel for the whole runtime
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

//		GUI g = new GUI(80);
		new StartWindow();

		// TODO: Werte abfragen

//		g.createContent();

	}

}
