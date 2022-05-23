package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompanyTileTest {

	@Test
	public void testBuyCompany() {
		Player player = new Player();
		player.setMoney(Long.valueOf(400));
		CompanyTile company = new CompanyTile(Long.valueOf(200), 2);
		company.buyCompany(player);
		assertTrue(company.getOwner() != null);
	}

}
