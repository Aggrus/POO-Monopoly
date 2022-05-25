package model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
public class Game
{

	private static List<AbstractCard> cards;

	private static Integer numPlayers;

	private static List<Player> playerList;

	private static List<Property> properties;

	private Game()
	{
	}

	public static List<AbstractCard> createEmptyDeck()
	{
		Game.cards = new ArrayList();
		return cards;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the cards.
	 * @see #cards
	 */
	public static List<AbstractCard> getCards()
	{
		return cards;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the numPlayers.
	 * @see #numPlayers
	 */
	public static Integer getNumPlayers()
	{
		return Game.numPlayers;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the playerList.
	 * @see #playerList
	 */
	public static List<Player> getPlayerList()
	{
		return Game.playerList;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the board.
	 * @see #properties
	 */
	public static List<Property> getProperties()
	{
		return properties;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param cards
	 *            The cards to set.
	 * @see #cards
	 */
	public static void setCards( final List<AbstractCard> cards )
	{
		Game.cards = cards;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param numPlayers
	 *            The numPlayers to set.
	 * @see #numPlayers
	 */
	public static void setNumPlayers( final Integer numPlayers )
	{
		Game.numPlayers = numPlayers;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param playerList
	 *            The playerList to set.
	 * @see #playerList
	 */
	public static void setPlayerList( final List<Player> playerList )
	{
		Game.playerList = playerList;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param board
	 *            The board to set.
	 * @see #properties
	 */
	public static void setProperties( final List<Property> board )
	{
		Game.properties = board;
	}

}
