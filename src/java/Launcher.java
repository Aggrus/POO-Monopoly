import View.MainFrame;
import model.ApplyRules;
import model.Game;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
public class Launcher
{

	public static void main( final String[] args )
	{
		Game.createEmptyDeck();
		ApplyRules.shuffleDeck();
		MainFrame.getInstance();
	}

}
