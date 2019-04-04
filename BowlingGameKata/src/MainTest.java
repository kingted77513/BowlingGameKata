import game.Game;

public class MainTest {
	public static void main(String[] args) {
		System.out.println("Welcome to play bowling game");
		Game g = new Game();
		g.roll(10);
		g.roll(10);
		System.out.println("Current socre: " + g.score());
		System.out.println("Bowling game is over");
	}
}
