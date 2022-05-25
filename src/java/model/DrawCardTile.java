package model;

import java.util.List;
import java.util.Random;

import enums.TileEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 20, 2022
 */
class DrawCardTile
	extends AbstractTile
{

	/**
	 * <p>
	 * </p>
	 */
	public DrawCardTile()
	{
		setCanPurchase( false );
		setGorup( null );
		setOwner( null );
		setSpecialProperty( TileEnum.NONE );
		setValue( Long.valueOf( 0 ) );
	}

	public AbstractCard getDrawnCard()
	{
		return this.drawnCard;
	}

	protected void setDrawnCard( final AbstractCard drawnCard )
	{
		this.drawnCard = drawnCard;
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
		final List<AbstractCard> deck = Game.getCards();
		final Random card = new Random();
		final AbstractCard curCard = deck.get( card.nextInt( Game.getCards().size() - 1 ) );
		curCard.cardRule( player );
		setDrawnCard( curCard );
		deck.remove( curCard );
		if ( deck.isEmpty() )
		{
			ApplyRules.shuffleDeck();
		}
	}

	private AbstractCard drawnCard;

}
