package Ejercicio01;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class DibujoAnimado extends Rectangle {
	Applet applet;
	private Image[] imagenes;
	int cont;
	int y = 150;
	int x = 150;
	int posX, posY;
	boolean salto = false;
	boolean caida = false;

	public DibujoAnimado(Image[] imgs, Applet applet, int posX, int posY) {
		super(posX, posY, 100, 100);
		imagenes = imgs;
		this.posX = posX;
		this.posY = posY;
		this.applet = applet;
	}

	public void dibujar(Graphics g) {
		g.drawImage(imagenes[cont], posX, posY, 100, 100, applet);
	}

	public void setImagenes(Image[] imagenes) {
		this.imagenes = imagenes;
	}

	public void actualizar() {
		cont++;
		x += 30;
		if (cont == 4) {
			cont = 0;
		}
		/*
		 * if (salto == true && y >= -50 && caida == false) { y -= 50; cont = 0; if (y
		 * == -50) { caida = true; salto = false; } } if (caida == true) { y += 50; cont
		 * = 1; if (y == 150) { caida = false; } }
		 */
	}
}
