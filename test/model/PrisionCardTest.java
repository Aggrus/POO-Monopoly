package model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrisionCardTest
{

	@Test
	public void testCardRule()
	{
		final Player player = new Player();
		final PrisionCard card = new PrisionCard( 23, false, "link" );
		card.cardRule( player );
		assertTrue( "Jogador na prisao", player.isInPrision() );
	}
}
