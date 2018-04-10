package Ejercicio04me;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Boton extends Rectangle {

	Image imagen;
	static final int DIM = 60;
	Applet applet;

	public Boton(Image imagen, Applet applet) {
		super(0, 0, DIM, DIM);
		this.applet = applet;
		this.imagen = imagen;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagen, x, y, width, height, applet);
	}
}
