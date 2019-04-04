package game.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Game;

class GameTest {
	
	Game g;

	@BeforeEach
	void setUp() throws Exception {
		g = new Game();
	}

	@Test
	void testGutterGame() {
		int exptected = 0;
		
		int rollTimes = 20;
		int pins = 0;
		rollMany(rollTimes, pins);
		int actual = g.score();
		assertEquals(exptected, actual);
	}

	private void rollMany(int rollTimes, int pins) {
		for (int i = 0 ; i < rollTimes ; i++) {
			g.roll(pins);
		}
	}
	
	@Test
	void testAllOnesGame() {
		int exptected = 20;
		
		int rollTimes = 20;
		int pins = 1;
		rollMany(rollTimes, pins);
		int actual = g.score();
		assertEquals(exptected, actual);
	}
	
	@Test
	void testOneSpareGame() {
		int exptected = 16;
		
		rollSpare();
		g.roll(3);
		
		int rollTimes = 17;
		int pins = 0;
		rollMany(rollTimes, pins);
		int actual = g.score();
		assertEquals(exptected, actual);
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}
	
	@Test
	void testOneStrikeGame() {
		int exptected = 24;
		
		rollStrike();
		g.roll(3);
		g.roll(4);
		
		int rollTimes = 16;
		int pins = 0;
		rollMany(rollTimes, pins);
		int actual = g.score();
		assertEquals(exptected, actual);
	}

	private void rollStrike() {
		g.roll(10);
	}
	
	@Test
	void testPerfectGame() {
		int exptected = 300;
		
		int rollTimes = 12;
		int pins = 10;
		rollMany(rollTimes, pins);
		int actual = g.score();
		assertEquals(exptected, actual);
	}
}
