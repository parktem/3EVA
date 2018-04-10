package Ejercicio05;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle {
	public static final int DIM = 20;
	Image fondo, bomba;
	private boolean mina, pulsada;
	private int minasTanjentes;

	public Casilla(int posX, int posY, Image fondo, Image bomba) {
		super(posX, posY, DIM, DIM);
		this.fondo = fondo;
		this.bomba = bomba;
		mina = false;
		pulsada = false;
		minasTanjentes = 0;
	}

	public void dibujar(Graphics g, Applet a) {
		if (!isPulsada())
			g.drawImage(fondo, x, y, width, height, a);
		else {
			if (mina)
				g.drawImage(bomba, x, y - 12, width, height, a);
			else
				g.drawString("" + minasTanjentes, x + 5, y + 13);
		}
	}

	public boolean isMina() {
		return mina;
	}

	public boolean isPulsada() {
		return pulsada;
	}

	public void setMina(boolean m) {
		mina = m;
	}

	public void setPulsada(boolean p) {
		pulsada = p;
	}

	public void setminasTanjentes(int t) {
		minasTanjentes = t;
	}

	public int getminasTanjentes() {
		return minasTanjentes;
	}
}
