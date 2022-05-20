package model;

import enums.TileEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 20, 2022
 */
class TaxesTile
	extends AbstractTile
{

	/**
	 * <p>
	 * </p>
	 */
	public TaxesTile()
	{
		setCanPurchase( false );
		setGorup( null );
		setOwner( null );
		setSpecialProperty( TileEnum.GIVE );
		setValue( Long.valueOf( 200 ) );
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param player
	 * @see model.AbstractTile#tileRule(model.Player)
	 */
	@Override
	public void tileRule( final Player player )
	{
		player.loseMoney( getValue() );
	}
}
