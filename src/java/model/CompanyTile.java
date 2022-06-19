package model;

import Exception.IllegalRuleException;
import enums.TileEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 20, 2022
 */
class CompanyTile
	extends AbstractTile
{

	/**
	 * <p>
	 * </p>
	 */
	public CompanyTile( final Long value, final Integer multiplier )
	{
		setMultiplier( multiplier );
		setCanPurchase( true );
		setGorup( null );
		setOwner( null );
		setSpecialProperty( TileEnum.NONE );
		setValue( value );
	}

	public void buyCompany( final Player player )
		throws IllegalRuleException
	{
		if ( null != getOwner() )
		{
			throw new IllegalRuleException( "Propriedade já tem dono!" );
		}
		player.loseMoney( getValue() );
		setOwner( player );
		setCanPurchase( false );
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the multiplier.
	 * @see #multiplier
	 */
	private Integer getMultiplier()
	{
		return this.multiplier;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param multiplier
	 *            The multiplier to set.
	 * @see #multiplier
	 */
	private void setMultiplier( final Integer multiplier )
	{
		this.multiplier = multiplier;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param player
	 * @see model.AbstractTile#tileRule(model.Player)
	 */
	@Override
	public void tileRule( final Integer playerId )
	{
		Player player = Game.getPlayerList().get(playerId);
		if ( !player.equals( getOwner() ) )
		{
			final Integer rollTotal = Dice.simpleRoll().stream().mapToInt( r -> r ).sum();
			player.loseMoney( Long.valueOf( rollTotal * getMultiplier() ) );
		}
	}

	private Integer multiplier;

}
