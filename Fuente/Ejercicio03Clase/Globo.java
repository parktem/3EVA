package Ejercicio03Clase;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Globo extends Rectangle {

	Image imagen;
	Applet applet;

	public Globo(Image imagen, Applet applet) {
		super(450, 450, 100, 100);
		this.imagen = imagen;
		this.applet = applet;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagen, x, y, 100, 100, applet);
	}

	public void actualizar() {
		y -= 5;
	}

}
