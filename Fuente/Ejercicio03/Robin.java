package Ejercicio03;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Robin {

	static int posY = 50;
	Image imagen;
	Applet applet;

	public Robin(Image imagen, Applet applet) {
		this.imagen = imagen;
		this.applet = applet;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagen, 20, posY, 100, 100, applet);
	}

}
