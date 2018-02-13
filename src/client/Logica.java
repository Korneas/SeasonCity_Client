package client;

import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import serial.Validation;

public class Logica implements Observer {

	private PApplet app;
	private Communication com;
	private int col;
	private boolean turn;

	public Logica(PApplet app) {
		super();
		this.app = app;
		com = new Communication();
		new Thread(com).start();
		com.setBoss(this);
		com.setId(1);

		col = 0;
	}

	public void ejecutar() {
		app.background(col, col / 2, col);
		if (turn) {
			app.ellipse(150, 150, 30, 30);
		}
		app.text("Jugador " + com.getId(), 200, 200);
		app.textAlign(PApplet.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Validation) {
			Validation val = (Validation) arg;
			if (val.isCheck()) {
				if (val.getType().contains("start")) {
					if (col == 0) {
						col = 150;
					} else {
						col = 0;
					}
				} else if (val.getType().contains("yourTurn")) {
					turn = true;
				}
			} else {
				if (val.getType().contains("yourTurn")) {
					turn = false;
				}
			}
		}
	}

}
