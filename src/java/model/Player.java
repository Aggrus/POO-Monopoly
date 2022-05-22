package model;

import enums.PlayerColorEnum;

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

	public void addPriosionTime()
	{
		this.prisionTime++;
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
	 * @return Returns the color.
	 * @see #color
	 */
	public PlayerColorEnum getColor()
	{
		return this.color;
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
	 * @return Returns the prisionTime.
	 * @see #prisionTime
	 */
	public Integer getPrisionTime()
	{
		return this.prisionTime;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the roundTrips.
	 * @see #roundTrips
	 */
	public Integer getRoundTrips()
	{
		return this.roundTrips;
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
	 * @return Returns the inGame.
	 * @see #inGame
	 */
	public boolean isInGame()
	{
		return this.inGame;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the inPriosion.
	 * @see #inPrision
	 */
	public boolean isInPrision()
	{
		return this.inPrision;
	}

	public void loseMoney( final Long amount )
	{
		setMoney( getMoney() - amount );
		playerStatus();
		if ( !isInGame() )
		{
			Game.getPlayerList().remove( this );
		}
	}

	public void playerStatus()
	{
		if ( getMoney() <= 0 )
		{
			setInGame( false );
		}
	}

	public void resetPrisionTime()
	{
		this.prisionTime = 0;
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
	 * @param color
	 *            The color to set.
	 * @see #color
	 */
	public void setColor( final PlayerColorEnum color )
	{
		this.color = color;
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
	 * @param inGame
	 *            The inGame to set.
	 * @see #inGame
	 */
	private void setInGame( final boolean inGame )
	{
		this.inGame = inGame;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param inPriosion
	 *            The inPriosion to set.
	 * @see #inPrision
	 */
	public void setInPrision( final boolean inPriosion )
	{
		this.inPrision = inPriosion;
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
	 *
	 * @param roundTrips
	 *            The roundTrips to set.
	 * @see #roundTrips
	 */
	public void setRoundTrips( final Integer roundTrips )
	{
		this.roundTrips = roundTrips;
	}

	private Integer boardPosition;

	private PlayerColorEnum color;

	private boolean freeRide;

	private boolean inGame;

	private boolean inPrision;

	private Long money;

	private Double positionX;

	private Double positionY;

	private Integer prisionTime;

	private Integer roundTrips;

}
