package Ejercicio03;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class RobinApp extends Applet implements Runnable {
	boolean activacion = false;
	Thread animacion;
	static Robin robin;
	Image imagenrobin;
	Image imagenflecha;
	Image imagenglobo;
	List<Globo> globo;
	static int cont = 0;
	Flecha flecha;
	int contador = 0;

	public void init() {
		setSize(700, 700);
		imagenrobin = getImage(getCodeBase(), "imagenes/arquero.gif");
		imagenflecha = getImage(getCodeBase(), "imagenes/flecha.gif");
		imagenglobo = getImage(getCodeBase(), "imagenes/globo.gif");
		robin = new Robin(imagenrobin, this);
		globo = new ArrayList<Globo>();
		globo.add(new Globo(imagenglobo, this));
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		robin.dibujar(g);
		for (int i = 0; i < globo.size(); i++) {
			globo.get(i).dibujar(g);
		}
		g.drawString(String.valueOf(contador), 650, 20);
		if (activacion == true) {
			flecha.dibujar(g);
		}

		for (int i = 0; i < globo.size(); i++) {
			if (globo.get(i).y == 0) {
				g.drawString("GAME OVER", 350, 350);
				animacion.stop();
			}
		}
	}

	public void run() {
		while (true) {
			for (int i = 0; i < globo.size(); i++) {
				globo.get(i).actualizar();
			}
			if (activacion == true) {
				flecha.actualizar();
				for (int j = 0; j < globo.size(); j++) {
					if (globo.get(j).intersects(flecha)) {
						globo.remove(j);
						flecha.y = 800;
						contador++;
					}
				}
			}
			repaint();
			try {
				Thread.sleep(50);
				cont++;
				if (cont % 30 == 0) {
					globo.add(new Globo(imagenglobo, this));
				}
			} catch (InterruptedException e) {

			}
		}
	}

	public boolean mouseMove(Event ev, int x, int y) {
		robin.posY = y;
		return true;
	}

	public boolean mouseDown(Event ev, int x, int y) {
		flecha = new Flecha(imagenflecha, this);
		activacion = true;
		repaint();
		return true;
	}
}
