package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.Game;

public class MainFrame
	extends JFrame
	implements Observer
{

	private static MainFrame main_frame = null;

	private static int num_players = 0;

	private MainFrame()
	{
		final Toolkit tk = Toolkit.getDefaultToolkit();
		final Dimension screenSize = tk.getScreenSize();
		final int screen_width = screenSize.width;
		final int screen_height = screenSize.height;
		final int x = ( screen_width / 2 ) - ( this.DFLT_WIDTH / 2 );
		final int y = ( screen_height / 2 ) - ( this.DFLT_HEIGHT / 2 );
		setBounds( x, y, this.DFLT_WIDTH, this.DFLT_HEIGHT );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		ScreenManager();
	}

	public static MainFrame getMainFrame()
	{
		if ( main_frame == null )
		{
			main_frame = new MainFrame();
			main_frame.setTitle( "Jogo Monopoly" );
			main_frame.setVisible( true );
		}
		return main_frame;
	}

	public void ScreenManager()
	{
		if ( num_players == 0 )
		{
			getContentPane().add( MenuScreen.getMenuScreen( this.DFLT_WIDTH, this.DFLT_HEIGHT ) );
		}
		else
		{
			getContentPane().removeAll();
			getContentPane().add( GameScreen.getGameScreen( this.DFLT_WIDTH, this.DFLT_HEIGHT ) );
			getContentPane().revalidate();
			getContentPane().repaint();
		}
	}

	public void set_num_players( final int n )
	{
		num_players = n;
		System.out.printf( "num_players = %d\n", num_players );
		ScreenManager();
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param o
	 * @see View.Observer#update(java.lang.Object)
	 */
	@Override
	public void update( final Object o )
	{
		num_players = Game.getNumPlayers();
		ScreenManager();
	}

	public final int DFLT_HEIGHT = 700;

	public final int DFLT_WIDTH = 1100;
}
