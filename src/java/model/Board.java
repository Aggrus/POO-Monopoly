package model;

import java.util.List;

/**
 * <p>
 * </p>
 * 
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
public class Board
{

	/**
	 * <p>
	 * </p>
	 * 
	 * @return Returns the boardPositions.
	 * @see #boardPositions
	 */
	public List<Property> getBoardPositions()
	{
		return this.boardPositions;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param boardPositions
	 *            The boardPositions to set.
	 * @see #boardPositions
	 */
	public void setBoardPositions( final List<Property> boardPositions )
	{
		this.boardPositions = boardPositions;
	}

	private List<Property> boardPositions;
}
