package model;

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

	private Long money;

	private Double positionX;

	private Double positionY;

}
