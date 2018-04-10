package Calculadora;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class CalculadoraApp extends Frame {

	public static void main(String[] args) {
		CalculadoraApp calculadora = new CalculadoraApp();
	}

	public CalculadoraApp() {
		super("Calculadora");
		setup();
		pack();
		setSize(300, 300);
		show();
	}

	public void setup() {
		Panel principal = new Panel();
		principal.setLayout(new GridLayout(5, 3));
		Panel[][] pbotones = new Panel[4][3];
		for (int i = 0; i < pbotones[i].length; i++) {
			for (int j = 0; j < pbotones[i].length; j++) {
				pbotones[i][j] = new Panel();
				pbotones[i][j].add(new Button(String.valueOf(((i * 3) + j) + 1)));
			}
		}
		for (int i = 0; i < pbotones[i].length; i++) {
			for (int j = 0; j < pbotones[i].length; j++) {
				principal.add(pbotones[i][j]);
			}
		}
		/*
		 * pbotones[3][2] = new Panel(); pbotones[3][2].add(new Button("0"));
		 * principal.add(pbotones[3][2]);
		 */

		add("South", principal);

	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}
}
