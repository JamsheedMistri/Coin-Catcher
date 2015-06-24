package day2;

import java.util.ArrayList;

import apcs.Window;

public class CoinCatcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window.size(500, 800);
		int score = 0;
		int fontsize = 30;
		
		player p = new player();
		//normal
		ArrayList<Coin> coins = new ArrayList<Coin>();
		

		
		//bad
		ArrayList<BadCoin> bcoins = new ArrayList<BadCoin>();
		for (int i = 0; i < 10; i++) {
			coins.add(new Coin());
		}
		
		//rare
		ArrayList<RareCoin> rcoins = new ArrayList<RareCoin>();
		for (int i = 0; i < coins.size() / 10; i++) {
			rcoins.add(new RareCoin());
		}
		
		for (int i = 0; i < coins.size() - 2; i++) {
			bcoins.add(new BadCoin());
		}
		
		while (true) {
			Window.out.background("light blue");
			Window.out.color("purple");
			Window.out.font("monospace", fontsize);
			Window.out.print("Score: " + score, Window.width() / 2 - fontsize * 2, Window.height() - 50);
			
			p.draw();
			p.move();
			
			for (int i = 0; i < coins.size(); i++) {
				coins.get(i).draw();
				coins.get(i).move();
				if (coins.get(i).checkCollision(p)) {
					score += 5;
					coins.get(i).reset();
				}
				if (coins.get(i).y >= Window.height() + coins.get(i).radius) {
					coins.get(i).reset();
				}
			}
			
			//rare
			for (int i = 0; i < rcoins.size(); i++) {
				rcoins.get(i).draw();
				rcoins.get(i).move();
				if (rcoins.get(i).checkCollision(p)) {
					score += 15	;
					rcoins.get(i).reset();
				}
				if (rcoins.get(i).y >= Window.height() + rcoins.get(i).radius) {
					rcoins.get(i).reset();
				}
			}
			
			//bad
			for (int i = 0; i < bcoins.size(); i++) {
				bcoins.get(i).draw();
				bcoins.get(i).move();
				if (bcoins.get(i).checkCollision(p)) {
					score -= 10;
					bcoins.get(i).reset();
				}
				if (bcoins.get(i).y >= Window.height() + bcoins.get(i).radius) {
					bcoins.get(i).reset();
				}
			}
			
			Window.frame();
		}
	}

}
