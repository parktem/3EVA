package Ejercicio05;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Buscaminas extends Applet implements Runnable {

	public static final int TAM = 8;
	public static final int NUMMINAS = 10;
	Thread animacion;
	Image imgMina, imgTapa;
	Casilla casillas[][];
	int posMina[];
	int numeros[];

	public void init() {
		imgMina = getImage(getCodeBase(), "imagenes/mina.jpg");
		imgTapa = getImage(getCodeBase(), "imagenes/cuadrado.gif");
		casillas = new Casilla[TAM][TAM];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j] = new Casilla((j * Casilla.DIM) + 20, (i * Casilla.DIM) + 20, imgTapa, imgMina);
			}
		}
		posMina = new int[NUMMINAS];
		numeros = new int[TAM * TAM];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i;
		}
		cargarAleatorios();

		contarMinas();

	}

	public void contarMinas() {
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				if (casillas[i][j].isMina() == false) {
					int posIInicio = ((i - 1) < 0) ? 0 : i - 1;
					int posIFin = ((i + 1) >= 0) ? TAM - 1 : i + 1;
					int posJInicio = ((j - 1) < 0) ? 0 : j - 1;
					int posJFin = ((j + 1) >= TAM) ? TAM - 1 : j + 1;
					int cont = 0;
					for (int a = posIInicio; a <= posIFin; a++) {
						for (int b = posJInicio; b < posJFin; b++) {
							if (casillas[a][b].isMina())
								cont++;
						}
					}
					casillas[i][j].setminasTanjentes(cont);
				}
			}
		}
	}

	public void cargarAleatorios() {
		int elementos = TAM * TAM;
		for (int i = 0; i < NUMMINAS; i++) {
			int aleatorio = (int) (Math.random() * elementos);
			posMina[i] = numeros[aleatorio];
			numeros[aleatorio] = numeros[elementos - 1];
			elementos--;
		}

		for (int i = 0; i < NUMMINAS; i++) {
			casillas[posMina[i] / TAM][posMina[i] % TAM].setMina(true);
		}
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j].dibujar(g, this);
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

	public boolean mouseDown(Event ev, int x, int y) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (casillas[i][j].contains(x, y)) {
					casillas[i][j].setPulsada(true);
				}
			}
		}
		repaint();
		return true;
	}

}
