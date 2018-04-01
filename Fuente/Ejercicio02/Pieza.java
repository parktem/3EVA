package Ejercicio02;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class Pieza extends Rectangle {

	final static int DIM = 60;
	Image[] imagenes;
	Applet applet;
	static Random r = new Random();
	int cont = 0;

	public Pieza(Image[] imagenes, Applet applet) {
		super(450 + r.nextInt(50), r.nextInt(500), DIM, DIM);
		this.imagenes = imagenes;
		this.applet = applet;
		cont++;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagenes[cont], x, y, DIM, DIM, applet);
	}

	public void actualizar() {
		cont++;
		if (cont == imagenes.length) {
			cont = 0;
		}
	}

}
