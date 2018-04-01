package Ejercicio01;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Caminar extends Applet implements Runnable {

	Thread animacion;
	Image fotogramas[][];
	List<DibujoAnimado> dibujoanimado;
	String[] fuente = { "Sprites/Guerrillero/g", "Sprites/Hampon/h", "Sprites/Vaquero/v" };
	int cont = 0;
	int indice = 0;

	public void init() {
		setSize(1800, 800);
		dibujoanimado = new ArrayList<DibujoAnimado>();
		fotogramas = new Image[3][4];
		for (int i = 0; i < fotogramas.length; i++) {
			for (int j = 0; j < fotogramas[i].length; j++) {
				fotogramas[i][j] = getImage(getCodeBase(), (fuente[i] + j) + ".gif"); // léeme
																						// la

			}
			// direccion
			// de memoria donde
			// esté el codigo
			// base
		}
		for (int i = 0; i < 10; i++) {
			dibujoanimado.add(new DibujoAnimado(fotogramas[0], this, i * 52, i * 50));
		}
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < dibujoanimado.size(); i++) {
			dibujoanimado.get(i).dibujar(g);
		}

	}

	public void run() {
		while (true) {
			for (int i = 0; i < dibujoanimado.size(); i++) {
				dibujoanimado.get(i).actualizar();
			}
			repaint();
			try {
				Thread.sleep(200);

			} catch (InterruptedException e) {

			}
		}
	}

	public boolean keyDown(Event e, int tecla) {
		// G == 103-71
		// H == 104-72
		// V == 118-86
		for (int i = 0; i < dibujoanimado.size(); i++) {

			switch (tecla) {
			case 103:
				dibujoanimado.get(i).setImagenes(fotogramas[0]);
				break;
			case 104:
				dibujoanimado.get(i).setImagenes(fotogramas[1]);

				break;
			case 118:
				dibujoanimado.get(i).setImagenes(fotogramas[2]);

				break;
			case 71:
				dibujoanimado.get(i).setImagenes(fotogramas[0]);
				break;
			case 72:
				dibujoanimado.get(i).setImagenes(fotogramas[1]);

				break;
			case 86:
				dibujoanimado.get(i).setImagenes(fotogramas[2]);
				break;

			}

			if (tecla == 1004) {
				dibujoanimado.get(i).salto = true;
			}
		}
		return true;
	}

	public boolean mouseDown(Event ev, int x, int y) {

		for (int i = 0; i < dibujoanimado.size(); i++) {
			if (dibujoanimado.get(i).contains(x, y)) {
				dibujoanimado.remove(i);
			}
		}
		repaint();

		return true;
	}
}
