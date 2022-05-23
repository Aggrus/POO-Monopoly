package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrisionCardTest {

	@Test
	public void testCardRule() {
		Player player = new Player();
		PrisionCard card = new PrisionCard();
		card.cardRule(player);
		assertTrue("Jogador na prisao",player.isInPrision());
	}
}
