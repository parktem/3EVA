package Ejercicio04me;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class JuegoBotones extends Applet implements Runnable {

	Thread animacion;
	Image[] imagenboton;
	Boton[] botones;
	Rectangle[][] tabla;

	public void init() {
		setSize(600, 600);
		imagenboton = new Image[24];
		botones = new Boton[24];
		tabla = new Rectangle[5][5];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				tabla[i][j] = new Rectangle((j * 60) + 60, (i * 60) + 60, 60, 60);
			}
		}
		for (int i = 0; i < imagenboton.length; i++) {
			imagenboton[i] = getImage(getCodeBase(), "botones/" + (i + 1) + ".gif");
		}
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new Boton(imagenboton[i], this);
		}

	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				g.drawRect(tabla[i][j].x, tabla[i][j].y, tabla[i][j].width, tabla[i][j].height);
			}
		}
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

			}
		}
	}

}
