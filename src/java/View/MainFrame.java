package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Controller.Observer.Observer;

public class MainFrame
	extends JFrame
	implements Observer
{

	private static MainFrame mainFrame = null;

	private static int numPlayers = 0;

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

	public static MainFrame getInstance()
	{
		if ( mainFrame == null )
		{
			mainFrame = new MainFrame();
			mainFrame.setTitle( "Jogo Monopoly" );
			mainFrame.setVisible( true );
		}
		return mainFrame;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param o
	 * @see View.Observer#update(java.lang.Object)
	 */
	@Override
	public void notify( final int msg )
	{
		numPlayers = msg;
		ScreenManager();
	}

	public void ScreenManager()
	{
		if ( numPlayers == 0 )
		{
			getContentPane().add( MenuScreen.getInstance( this.DFLT_WIDTH, this.DFLT_HEIGHT ) );
		}
		else
		{
			getContentPane().removeAll();
			getContentPane().add( GameScreen.getInstance( this.DFLT_WIDTH, this.DFLT_HEIGHT ) );
			getContentPane().revalidate();
			getContentPane().repaint();
		}
	}

	public void set_num_players( final int n )
	{
		numPlayers = n;
		System.out.printf( "num_players = %d\n", numPlayers );
		ScreenManager();
	}

	public final int DFLT_HEIGHT = 700;

	public final int DFLT_WIDTH = 1100;
}
