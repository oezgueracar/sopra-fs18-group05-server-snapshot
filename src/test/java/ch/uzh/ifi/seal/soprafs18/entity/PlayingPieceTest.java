package ch.uzh.ifi.seal.soprafs18.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayingPieceTest {

	Player p1;

	@Before
	public void setUp() throws Exception {
		p1 = new Player();
		p1.setColor("red");
		p1.setup();
	}

	@Test
	public void setPosition() {
		p1.getPlayingPiece().setPosition(200);

		assertTrue(p1.getPlayingPiece().getPosition() == 200);
	}

	@Test
	public void getColor() {
		assertEquals("red", p1.getPlayingPiece().getColor());
	}

	@Test
	public void getPosition() {
		p1.getPlayingPiece().setPosition(200);

		assertTrue(p1.getPlayingPiece().getPosition() == 200);
	}
}