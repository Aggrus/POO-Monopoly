package model;

import enums.ColorEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
class Player
{

	public Player()
	{
		this.money = Long.valueOf( 4000 );
	}

	public Player( final Double positionX, final Double positionY )
	{
		this.money = Long.valueOf( 4000 );
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the boardPosition.
	 * @see #boardPosition
	 */
	public Integer getBoardPosition()
	{
		return this.boardPosition;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the money.
	 * @see #money
	 */
	public Long getMoney()
	{
		return this.money;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the positionX.
	 * @see #positionX
	 */
	public Double getPositionX()
	{
		return this.positionX;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the positionY.
	 * @see #positionY
	 */
	public Double getPositionY()
	{
		return this.positionY;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the freeRide.
	 * @see #freeRide
	 */
	public boolean isFreeRide()
	{
		return this.freeRide;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the inPriosion.
	 * @see #inPriosion
	 */
	public boolean isInPriosion()
	{
		return this.inPriosion;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param boardPosition
	 *            The boardPosition to set.
	 * @see #boardPosition
	 */
	public void setBoardPosition( final Integer boardPosition )
	{
		this.boardPosition = boardPosition;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param freeRide
	 *            The freeRide to set.
	 * @see #freeRide
	 */
	public void setFreeRide( final boolean freeRide )
	{
		this.freeRide = freeRide;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param inPriosion
	 *            The inPriosion to set.
	 * @see #inPriosion
	 */
	public void setInPriosion( final boolean inPriosion )
	{
		this.inPriosion = inPriosion;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param money
	 *            The money to set.
	 * @see #money
	 */
	public void setMoney( final Long money )
	{
		this.money = money;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param positionX
	 *            The positionX to set.
	 * @see #positionX
	 */
	public void setPositionX( final Double positionX )
	{
		this.positionX = positionX;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param positionY
	 *            The positionY to set.
	 * @see #positionY
	 */
	public void setPositionY( final Double positionY )
	{
		this.positionY = positionY;
	}

	/**
	 * <p>
	 * </p>
	 * @return Returns the color.
	 * @see #color
	 */
	public ColorEnum getColor()
	{
		return color;
	}

	/**
	 * <p>
	 * </p>
	 * @param color The color to set.
	 * @see #color
	 */
	public void setColor( ColorEnum color )
	{
		this.color = color;
	}

	private Integer boardPosition;

	private ColorEnum color;

	private boolean freeRide;

	private boolean inPriosion;

	private Long money;

	private Double positionX;

	private Double positionY;

}
