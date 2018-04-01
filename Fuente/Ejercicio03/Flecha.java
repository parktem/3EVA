package Ejercicio03;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Flecha extends Rectangle {

	Image imagen;
	Applet applet;

	public Flecha(Image imagen, Applet applet) {
		super(20, Robin.posY, 20, 20);
		this.imagen = imagen;
		this.applet = applet;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagen, x, y, 100, 100, applet);
	}

	public void actualizar() {
		x += 30;

	}

}
