package model;

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

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the board.
	 * @see #board
	 */
	public Board getBoard()
	{
		return this.board;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the numPlayers.
	 * @see #numPlayers
	 */
	public Integer getNumPlayers()
	{
		return this.numPlayers;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the playerList.
	 * @see #playerList
	 */
	public List<Player> getPlayerList()
	{
		return this.playerList;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param board
	 *            The board to set.
	 * @see #board
	 */
	public void setBoard( final Board board )
	{
		this.board = board;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param numPlayers
	 *            The numPlayers to set.
	 * @see #numPlayers
	 */
	public void setNumPlayers( final Integer numPlayers )
	{
		this.numPlayers = numPlayers;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param playerList
	 *            The playerList to set.
	 * @see #playerList
	 */
	public void setPlayerList( final List<Player> playerList )
	{
		this.playerList = playerList;
	}

	private Board board;

	private Integer numPlayers;

	private List<Player> playerList;

}
