package model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.IllegalRuleException;
import enums.PlayerColorEnum;

public class CompanyTileTest
{

	@Test( expected = IllegalRuleException.class )
	public void checkIllegalBuyCompany()
	{
		final CompanyTile company = new CompanyTile( Long.valueOf( 200 ), 2 );
		company.setOwner( new Player() );
		final Player illegal = new Player();
		illegal.setColor( PlayerColorEnum.BLUE );
		illegal.setMoney( Long.valueOf( 20 ) );
		company.buyCompany( illegal );
	}

	@Test
	public void testBuyCompany()
	{
		final Player player = new Player();
		player.setMoney( Long.valueOf( 400 ) );
		final CompanyTile company = new CompanyTile( Long.valueOf( 200 ), 2 );
		company.buyCompany( player );
		assertTrue( company.getOwner() != null );
		assertTrue( player.getMoney().equals( Long.valueOf( 200 ) ) );
	}
}
