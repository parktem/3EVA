package Ejercicio02;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Puzzle extends Applet {

	Image[] imagenes;
	Thread animacion;
	Pieza[] piezas;

	public void init() {
		setSize(500, 500);
		imagenes = new Image[25];
		piezas = new Pieza[25];
		for (int i = 0; i < imagenes.length; i++) {
			imagenes[i] = getImage(getCodeBase(), "directorioImagenes/" + (i + 1) + ".png");
		}
		for (int i = 0; i < imagenes.length; i++) {
			piezas[i] = new Pieza(imagenes, this);
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < imagenes.length; i++) {
			piezas[i].dibujar(g);
		}
	}

}
