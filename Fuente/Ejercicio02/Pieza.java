package Ejercicio02;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class Pieza extends Rectangle {

	boolean bloqueo = false;
	final static int DIM = 60;
	Image imagenes;
	Applet applet;
	private int posicion;
	static Random r = new Random();
	int cont = 0;

	public Pieza(Image imagenes, Applet applet, int posicion) {
		super(350 + r.nextInt(150), r.nextInt(500), DIM, DIM);
		this.imagenes = imagenes;
		this.applet = applet;
		this.posicion = posicion;
		cont++;
	}

	public int getPosicion() {
		return posicion;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagenes, x, y, DIM, DIM, applet);
	}

	public void actualizar() {

	}

}
