package day2;

import apcs.Window;

public class player {
	int x, y, width, height;

	public player() {
		x = Window.width() / 2;
		y = Window.height() - 100;
		width = 50;
		height = 20;
	}

	public void draw() {
		//Window.out.color("gray");
		//Window.out.rectangle(x, y, width, height);
		Window.out.image("bucket.png", x - 25, y);
	}

	public void move() {
		x = Window.mouse.getX();
	}
}
