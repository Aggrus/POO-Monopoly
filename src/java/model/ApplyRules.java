package model;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 22, 2022
 */
public class ApplyRules
{

	public static List<Integer> moveRollDice( final Player player )
	{
		final List<Integer> diceRoll = Dice.moveRoll();

		player.setInPrision( diceRoll.size() > 6 );

		if ( player.isInPrision() )
		{
			diceRoll.clear();
		}
		return diceRoll;
	}

	public static void shuffleDeck()
	{
		final List<AbstractCard> deck = Game.getCards();
		if ( !deck.isEmpty() )
		{
			deck.clear();
		}
		final String contextPath = "../data/sorteReves";
		Integer id = 1;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 25 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 150 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 80 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 200 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 50 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 50 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 100 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 100 ) ) );
		id++;
		deck.add( new FreeRideCard( id, contextPath + "chance" + id + ".png" ) );
		id++;
		deck.add( new StartPosCard( id, contextPath + "chance" + id + ".png", Long.valueOf( 200 ) ) );
		id++;
		deck.add( new StealCard( id, contextPath + "chance" + id + ".png", Long.valueOf( 50 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 45 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 30 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 100 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 100 ) ) );
		id++;
		deck.add( new DefaultCard( id, true, contextPath + "chance" + id + ".png", Long.valueOf( 20 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 15 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 25 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 45 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 30 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 100 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 40 ) ) );
		id++;
		deck.add( new PrisionCard( id, false, contextPath + "chance" + id + ".png" ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 30 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 50 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 25 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 30 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 45 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 50 ) ) );
		id++;
		deck.add( new DefaultCard( id, false, contextPath + "chance" + id + ".png", Long.valueOf( 50 ) ) );

	}

	public boolean checkPlayerFreed( final List<Integer> roll, final Player player )
	{

		player.setInPrision( !( roll.size() > 2 ) );

		if ( player.isInPrision() && player.getPrisionTime().equals( 4 ) )
		{
			player.loseMoney( Long.valueOf( 50 ) );
			player.setInPrision( false );
		}

		if ( player.isFreeRide() && player.isInPrision() )
		{
			player.setFreeRide( false );
			player.setInPrision( false );
		}
		return !player.isInPrision();
	}

}
