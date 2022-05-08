package model;

/**
 * <p>
 * </p>
 * 
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
class Card
{

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the description.
	 * @see #description
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the id.
	 * @see #id
	 */
	public Integer getId()
	{
		return this.id;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the isLuck.
	 * @see #isLuck
	 */
	public boolean isLuck()
	{
		return this.isLuck;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param description
	 *            The description to set.
	 * @see #description
	 */
	public void setDescription( final String description )
	{
		this.description = description;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param id
	 *            The id to set.
	 * @see #id
	 */
	public void setId( final Integer id )
	{
		this.id = id;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param isLuck
	 *            The isLuck to set.
	 * @see #isLuck
	 */
	public void setLuck( final boolean isLuck )
	{
		this.isLuck = isLuck;
	}

	private String description;

	private Integer id;

	private boolean isLuck;

}
