import model.Game;
import View.MainFrame;

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
		Game.setNumPlayers( 0 );
		MainFrame.getMainFrame();
	}

}