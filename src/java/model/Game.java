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
	private static Game game;

	private static boolean isOn;

	private static Integer numPlayers;


	private static List<Player> playerList;

	private static List<AbstractTile> tiles;

	private List<Observer> observadores = new ArrayList<Observer>();

	private Game()
	{
		createEmptyDeck();
		setOn( true );
		setPlayerList( new ArrayList<Player>() );
		setTiles( new ArrayList<AbstractTile>() );
	}

	public static List<AbstractCard> createEmptyDeck()
	{
		cards = new ArrayList<AbstractCard>();
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
	 * @return Returns the game.
	 * @see #game
	 */
	public static Game getInstance()
	{
		if ( game == null )
		{
			game = new Game();
		}
		return game;
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
	 * @see #tiles
	 */
	public static List<AbstractTile> getTiles()
	{
		return tiles;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the isOn.
	 * @see #isOn
	 */
	public static boolean isOn()
	{
		return isOn;
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
	 * @param isOn
	 *            The isOn to set.
	 * @see #isOn
	 */
	public static void setOn( final boolean isOn )
	{
		Game.isOn = isOn;
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
	 * @see #tiles
	 */
	public static void setTiles( final List<AbstractTile> board )
	{
		Game.tiles = board;
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

