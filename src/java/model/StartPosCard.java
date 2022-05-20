package model;

/**
 * <p>
 * </p>
 * 
 * @author gugaz
 * @version 1.0 Created on May 17, 2022
 */
class StartPosCard
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
		player.setBoardPosition( 0 );
		changeMoney( getGainOrLoss(), player );
	}

}
