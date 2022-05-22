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

	public static List<Integer> rollDice( final Player player )
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
		// Add cards to game;
	}

	public boolean checkPlayerFreed( final List<Integer> roll, final Player player )
	{

		player.setInPrision( roll.size() > 2 );

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
		return player.isInPrision();
	}

}
