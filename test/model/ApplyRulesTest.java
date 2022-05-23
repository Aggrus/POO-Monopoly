package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ApplyRulesTest {
	
	@Test
	public void testCheckPlayerFreedCase1() {
		final List<Integer> roll = new ArrayList<Integer>();
	    roll.add(3);
	    roll.add(3);
		Player player = new Player();
		player.resetPrisionTime();
		ApplyRules applyR = new ApplyRules();
		assertTrue("Não jogou 2 dados iguais, está na prisao", applyR.checkPlayerFreed(roll, player));
		assertTrue(player.isInPrision());
	}
	
	@Test
	public void testCheckPlayerFreedCase2() {
		final List<Integer> roll = new ArrayList<Integer>();
        roll.add(3);
        roll.add(3);
		Player player = new Player();
		player.resetPrisionTime();
		player.addPriosionTime();
		player.addPriosionTime();
		player.addPriosionTime();
		player.addPriosionTime();
		player.setMoney(Long.valueOf(400));
		ApplyRules applyR = new ApplyRules();
		assertFalse(player.isInGame());
		assertTrue(player.getPrisionTime().equals(4));
		assertTrue(player.getMoney().equals(Long.valueOf(400)));
		//assertTrue(player.isInPrision());
		assertFalse(applyR.checkPlayerFreed(roll, player));
	}
	
	@Test
	public void testCheckPlayerFreedCase3() {
		final List<Integer> roll = new ArrayList<Integer>();
        roll.add(3);
        roll.add(3);
		Player player = new Player();
		player.resetPrisionTime();
		player.setFreeRide(true);
		ApplyRules applyR = new ApplyRules();
		assertFalse(applyR.checkPlayerFreed(roll, player));
	}
}
