package model;

/**
 * <p>
 * </p>
 * 
 * @author gugaz
 * @version 1.0 Created on May 17, 2022
 */
class PrisionCard
	extends AbstractCard
{

	/**
	 * <p>
	 * </p>
	 * 
	 * @param player
	 * @see model.AbstractCard#cardRule(model.Player)
	 */
	@Override
	public
	void cardRule( final Player player )
	{
		player.setInPrision( true );
	}

}
