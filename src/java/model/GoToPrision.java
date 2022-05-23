package model;

import enums.TileEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 20, 2022
 */
class GoToPrision
	extends AbstractTile
{

	public GoToPrision()
	{
		setOwner( null );
		setCanPurchase( false );
		setGorup( null );
		setSpecialProperty( TileEnum.NONE );
		setValue( Long.valueOf( 0 ) );
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
		if ( player.isFreeRide() )
		{
			player.setFreeRide( false );
		}
		else
		{
			player.setInPriosion( true );
		}
	}

}
