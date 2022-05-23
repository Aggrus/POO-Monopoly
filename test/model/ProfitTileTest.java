package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfitTileTest {

	@Test
	public void testTileRule() {
		Player player = new Player();
		ProfitTile profit = new ProfitTile();
		player.setMoney(Long.valueOf(400));
		profit.tileRule(player);
		assertTrue(player.getMoney() > 400);
	}

}
