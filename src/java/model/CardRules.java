package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
class CardRules
{

	private void changeMoney( final Long amount, final Player player )
	{
		final Long newMoney = player.getMoney() + amount;
		player.setMoney( newMoney );
	}

	private Card getCardById( final Integer cardId )
	{
		final File file = new File( "../../../cards.csv" );
		FileReader fr;

		final StringBuffer sb = new StringBuffer();
		String line;
		Integer lineCount = 0;
		try
		{
			fr = new FileReader( file );
			final BufferedReader br = new BufferedReader( fr );
			while ( ( line = br.readLine() ) != null )
			{
				if ( lineCount == ( cardId - 1 ) )
				{
					sb.append( line );
				}
				lineCount++;
			}
			fr.close();
		}
		catch ( final FileNotFoundException e )
		{
			System.out.println( e );
		}
		catch ( final IOException f )
		{
			System.out.println( f );
		}

		final String cardLine = sb.toString();
		final String[] cardElements = cardLine.split( ";" );
		final Card card = new Card();
		card.setLuck( getLuck( cardElements[0] ) );
		card.setDescription( cardElements[1] );
		card.setMoney( Long.valueOf( cardElements[2] ) );
		card.setId( cardId );
		return card;
	}

	public void getCardRule( final Player player, final Integer cardId )
	{
		final Card curCard = getCardById( cardId );
		final Long cardMoney = curCard.getGainOrLoss();
		switch ( cardId )
		{
			case 8 :
			{
				player.setFreeRide( true );
				break;
			}
			case 9 :
			{
				player.setBoardPosition( 0 );
				changeMoney( cardMoney, player );
				break;
			}
			case 10 :
			{
				// Receba 50 de cada jogador
			}
			case 22 :
			{
				player.setInPriosion( true );
				break;
			}

			default :
			{
				changeMoney( cardMoney, player );
				break;
			}
		}
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param string
	 * @return
	 */
	private boolean getLuck( final String luck )
	{
		return luck == "Sorte";

	}

}
