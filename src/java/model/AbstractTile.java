package model;

import enums.TileColorEnum;
import enums.TileEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */

abstract class AbstractTile
{

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
	 * @return Returns the canPurchase.
	 * @see #canPurchase
	 */
	public boolean getCanPurchase()
	{
		return this.canPurchase;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the gorup.
	 * @see #group
	 */
	public TileColorEnum getGorup()
	{
		return this.group;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the owner.
	 * @see #owner
	 */
	public Player getOwner()
	{
		return this.owner;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the specialProperty.
	 * @see #specialProperty
	 */
	public TileEnum getSpecialProperty()
	{
		return this.specialProperty;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the value.
	 * @see #value
	 */
	public Long getValue()
	{
		return this.value;
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
	 * @param canPurchase
	 *            The canPurchase to set.
	 * @see #canPurchase
	 */
	protected void setCanPurchase( final boolean canPurchase )
	{
		this.canPurchase = canPurchase;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param gorup
	 *            The gorup to set.
	 * @see #group
	 */
	protected void setGorup( final TileColorEnum gorup )
	{
		this.group = gorup;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param owner
	 *            The owner to set.
	 * @see #owner
	 */
	protected void setOwner( final Player owner )
	{
		this.owner = owner;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param specialProperty
	 *            The specialProperty to set.
	 * @see #specialProperty
	 */
	protected void setSpecialProperty( final TileEnum specialProperty )
	{
		this.specialProperty = specialProperty;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param value
	 *            The value to set.
	 * @see #value
	 */
	protected void setValue( final Long value )
	{
		this.value = value;
	}

	public abstract void tileRule( Player player );

	private Integer boardPosition;

	private boolean canPurchase;

	private TileColorEnum group;

	private Player owner;

	private TileEnum specialProperty;

	private Long value;

}
