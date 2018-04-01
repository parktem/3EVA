package Ejercicio02;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Puzzle extends Applet {

	Image[] imagenes;
	Thread animacion;
	Pieza[] piezas;
	Pieza actual;
	Rectangle[][] tabla;

	public void init() {
		setSize(600, 600);
		imagenes = new Image[25];
		piezas = new Pieza[25];
		tabla = new Rectangle[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tabla[i][j] = new Rectangle(j * 60 + 20, i * 60 + 20, 60, 60);
			}
		}
		for (int i = 0; i < imagenes.length; i++) {
			imagenes[i] = getImage(getCodeBase(), "directorioImagenes/" + (i + 1) + ".png");
		}
		for (int i = 0; i < imagenes.length; i++) {
			piezas[i] = new Pieza(imagenes[i], this, i);
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dibujarrect(g, tabla[i][j]);
			}
		}
		for (int i = 0; i < imagenes.length; i++) {
			piezas[i].dibujar(g);
		}
	}

	public void dibujarrect(Graphics g, Rectangle tabla) {
		g.drawRect(tabla.x, tabla.y, 60, 60);
	}

	public boolean mouseDown(Event ev, int x, int y) {

		for (int i = 0; i < imagenes.length; i++) {
			if (piezas[i].contains(x, y)) {
				actual = piezas[i];
			}
		}

		return true;
	}

	public boolean mouseUp(Event ev, int x, int y) {
		if (actual != null)
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (actual.intersects(tabla[i][j]) && ((i * 5 + j) == actual.getPosicion())
							&& actual.bloqueo == false) {
						actual.x = tabla[i][j].x;
						actual.y = tabla[i][j].y;
						actual.bloqueo = true;

					}
				}
			}
		actual = null;
		repaint();
		return true;
	}

	public boolean mouseDrag(Event ev, int x, int y) {
		if (actual != null && actual.bloqueo == false) {
			actual.x = x - 30;
			actual.y = y - 30;
			repaint();
		}
		return true;
	}

}
