package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ApplyRulesTest
{

	@Test
	public void testCheckPlayerFreedCase1NotFree()
	{
		final List<Integer> roll = new ArrayList<Integer>();
		roll.add( 3 );
		roll.add( 3 );
		final Player player = new Player();
		player.resetPrisionTime();
		final ApplyRules applyR = new ApplyRules();
		assertFalse( "Não jogou 2 dados iguais, está na prisao", applyR.checkPlayerFreed( roll, player ) );
		assertTrue( player.isInPrision() );
	}

	@Test
	public void testCheckPlayerFreedCaseFreeByMoney()
	{
		final List<Integer> roll = new ArrayList<Integer>();
		roll.add( 3 );
		roll.add( 2 );
		final Player player = new Player();
		player.resetPrisionTime();
		player.addPriosionTime();
		player.addPriosionTime();
		player.addPriosionTime();
		player.addPriosionTime();
		player.setMoney( Long.valueOf( 400 ) );
		final ApplyRules applyR = new ApplyRules();
		assertTrue( player.getPrisionTime().equals( 4 ) );
		assertFalse( player.isInPrision() );
		assertTrue( applyR.checkPlayerFreed( roll, player ) );
		assertTrue( String.format( "%d", player.getMoney() ), player.getMoney().equals( Long.valueOf( 350 ) ) );
	}

	@Test
	public void testCheckPlayerFreedCaseFreeByRoll()
	{
		final List<Integer> roll = new ArrayList<Integer>();
		roll.add( 3 );
		roll.add( 3 );
		roll.add( 5 );
		roll.add( 1 );
		final Player player = new Player();
		player.resetPrisionTime();
		player.setFreeRide( true );
		final ApplyRules applyR = new ApplyRules();
		assertTrue( applyR.checkPlayerFreed( roll, player ) );
	}

	@Test
	public void testdeckShuffle()
	{
		Game.createEmptyDeck();
		ApplyRules.shuffleDeck();
		final List<AbstractCard> deck = Game.getCards();
		final Player player = new Player();
		player.setMoney( Long.valueOf( 0 ) );
		final DefaultCard normalCard = ( DefaultCard ) deck.get( 3 );
		normalCard.cardRule( player );
		assertTrue( player.getMoney().equals( Long.valueOf( normalCard.getMoney() ) ) );

		final StartPosCard specialOne = ( StartPosCard ) deck.get( 9 );
		player.setBoardPosition( 25 );
		specialOne.cardRule( player );
		assertTrue( player.getBoardPosition().equals( 0 ) );
		assertFalse( "Money did not change!", player.getMoney().equals( Long.valueOf( normalCard.getMoney() ) ) );
		assertTrue( player.getMoney().equals( normalCard.getMoney() + specialOne.getMoney() ) );

	}
}
