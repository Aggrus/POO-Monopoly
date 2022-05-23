package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 20, 2022
 */
class Dice
{

	private static Random diceOne;

	private static Random diceTwo;

	/**
	 * <p>
	 * </p>
	 */
	public Dice()
	{
		diceOne = new Random();
		diceTwo = new Random();
	}

	public static ArrayList<Integer> moveRoll()
	{
		final ArrayList<Integer> roll = simpleRoll();
		while ( roll.get( roll.size() - 1 ).equals( roll.get( roll.size() - 2 ) ) )
		{
			roll.addAll( simpleRoll() );
		}
		return roll;
	}

	public static ArrayList<Integer> simpleRoll()
	{
		final ArrayList<Integer> dice = new ArrayList();

		final Integer rollOne = diceOne.nextInt( 6 );
		final Integer rollTwo = diceTwo.nextInt( 6 );
		dice.add( rollOne );
		dice.add( rollTwo );
		return dice;
	}

}
