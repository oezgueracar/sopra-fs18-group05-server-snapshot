package ch.uzh.ifi.seal.soprafs18.entity.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void equals() {
        Card b1 = new Card();
        Card b2 = new Card();

        b1.equals(b1);
        b1.equals(b2);
        b1.equals(null);
    }
}