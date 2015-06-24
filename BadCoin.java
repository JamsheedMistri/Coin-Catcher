package day2;

public class BadCoin extends Coin {
	public BadCoin() {
		color = "dark red";
		speed = super.speed - 2;
		radius = super.radius * 2;
		
	}
}
