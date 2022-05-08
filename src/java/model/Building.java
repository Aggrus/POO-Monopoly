package model;

import enums.BuildingEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
class Building
{

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
	 * @return Returns the price.
	 * @see #price
	 */
	public Long getPrice()
	{
		return this.price;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the property.
	 * @see #property
	 */
	public Property getProperty()
	{
		return this.property;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param owner
	 *            The owner to set.
	 * @see #owner
	 */
	public void setOwner( final Player owner )
	{
		this.owner = owner;
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
	 * @param price
	 *            The price to set.
	 * @see #price
	 */
	public void setPrice( final Long price )
	{
		this.price = price;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param property
	 *            The property to set.
	 * @see #property
	 */
	public void setProperty( final Property property )
	{
		this.property = property;
	}

	/**
	 * <p>
	 * </p>
	 * @return Returns the buildingType.
	 * @see #buildingType
	 */
	public BuildingEnum getBuildingType()
	{
		return buildingType;
	}

	/**
	 * <p>
	 * </p>
	 * @param buildingType The buildingType to set.
	 * @see #buildingType
	 */
	public void setBuildingType( BuildingEnum buildingType )
	{
		this.buildingType = buildingType;
	}

	private BuildingEnum buildingType;

	private Player owner;

	private Double positionX;

	private Double positionY;

	private Long price;

	private Property property;

}
