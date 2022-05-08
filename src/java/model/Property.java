package model;

import enums.PropertyEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
class Property
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
	 * @return Returns the specialProperty.
	 * @see #specialProperty
	 */
	public PropertyEnum getSpecialProperty()
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
	 * @param specialProperty
	 *            The specialProperty to set.
	 * @see #specialProperty
	 */
	public void setSpecialProperty( final PropertyEnum specialProperty )
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
	public void setValue( final Long value )
	{
		this.value = value;
	}

	private Integer boardPosition;

	private Double positionX;

	private Double positionY;

	private PropertyEnum specialProperty;

	private Long value;

}
