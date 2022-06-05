package model;

import java.util.ArrayList;
import java.util.List;

import Controller.Observer.Observable;
import Controller.Observer.Observer;

/**
 * <p>
 * </p>
 *
 * @author gugaz, arthurxvtv
 * @version 1.0 Created on May 8, 2022
 */
public class Game implements Observable
{

	private static List<AbstractCard> cards;

	private static int numPlayers;

	private static List<Player> playerList;

	private static List<Property> properties;

	private List<Observer> observadores = new ArrayList<Observer>();

	private static Game game = null;

	private Game() {}

	public static Game getInstance() {
		if (game == null) {
			game = new Game();
		}
		return game;
	}

	public static List<AbstractCard> createEmptyDeck()
	{
		cards = new ArrayList();
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
	public static Integer getNumPlayers() {
		return numPlayers;
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
		return playerList;
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
	public static void setCards( final List<AbstractCard> cards_list )
	{
		cards = cards_list;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param numPlayers
	 *            The numPlayers to set.
	 * @see #numPlayers
	 */
	public static void setNumPlayers( final int num_players ) {
		numPlayers = num_players;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param playerList
	 *            The playerList to set.
	 * @see #playerList
	 */
	public static void setPlayerList( final List<Player> player_list )
	{
		playerList = player_list;
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
		properties = board;
	}


	// implementações do design patter Observer

	public void add(Observer o) {
		observadores.add(o);
		o.notify(getNumPlayers());
	}

	public void remove(Observer o) {
		observadores.remove(o);
	}

}

