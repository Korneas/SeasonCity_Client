package client;

import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logica log;
	
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		PApplet.main("client.Main");
	}

	@Override
	public void settings() {
		size(400, 400);
	}
	
	@Override
	public void setup() {
		log = new Logica(this);
	}
	
	@Override
	public void draw() {
		background(0);
		log.ejecutar();
	}
	
}
