package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controller.GameController;
import Controller.Observer.PlayerObserver;

public class GameScreen
	extends JPanel
	implements MouseListener, PlayerObserver
{

	private static GameScreen game_screen = null;

	private static int num_players;

	private static int window_height;

	private static int window_width;

	private GameScreen( final int w, final int h, final int numPLayers )
	{
		GameScreen.window_width = w;
		GameScreen.window_height = h;
		GameScreen.num_players = numPLayers;
		GameController.getInstance().createPlayers();
		playerPositions = new ArrayList<Integer>(6);
		while (playerPositions.size() < num_players)
		{
			playerPositions.add(0);
		}
		addMouseListener( this );
	}

	public static GameScreen getInstance( final int w, final int h, final int numPLayers )
	{
		if ( game_screen == null )
		{
			game_screen = new GameScreen( w, h, numPLayers );
		}
		return game_screen;
	}

	// Desenha o Tabuleiro e o Background na tela
	private void draw_basic_board( final Graphics g )
	{
		g.drawImage( this.background_img, 0, 0, null );
		g
			.drawImage(
				this.board_img,
				17,
				( window_height - ( ( 90 * this.board_img.getHeight( null ) ) / 100 ) ) / 4,
				( 90 * this.board_img.getWidth( null ) ) / 100,
				( 90 * this.board_img.getWidth( null ) ) / 100,
				null );
	}

	private void drawPlayers( final Graphics g )
	{
		Integer index = 0;
		for ( final Image player : this.player_imgs )
		{
			final List<Integer> playerPos = PlayerView.getPlayerPos( index,  playerPositions.get(index) );
			g.drawImage( player, playerPos.get( 0 ), playerPos.get( 1 ), playerPos.get( 2 ), playerPos.get( 3 ), null );
			index++;
		}
	}

	// Importa as imagens que serão utilizadas ao longo do jogo
	private void import_images()
	{
		int i;
		try
		{
			// Importa a imagem do background
			this.background_img = ImageIO.read( new File( "src/java/data/background.png" ) );
			// Importa a imagem do tabuleiro
			this.board_img = ImageIO.read( new File( "src/java/data/tabuleiro.png" ) );
			// Importa as imagens dos dados
			for ( i = 0; i < 6; i++ )
			{
				this.dice_imgs[i] = ImageIO.read( new File( "src/java/data/dados/die_face_" + ( i + 1 ) + ".png" ) );
			}
			// Importa as imagens das cartas
			for ( i = 0; i < 30; i++ )
			{
				this.card_imgs[i] = ImageIO.read( new File( "src/java/data/sorteReves/chance" + ( i + 1 ) + ".png" ) );
			}
			// Importa as imagens das propriedades
			for ( i = 0; i < 22; i++ )
			{
				this.property_imgs[i] = ImageIO
					.read( new File( "src/java/data/territorios/territory" + ( i + 1 ) + ".png" ) );
			}
			// Importa as imagens das companhias
			for ( i = 0; i < 6; i++ )
			{
				this.company_imgs[i] = ImageIO
					.read( new File( "src/java/data/companhias/company" + ( i + 1 ) + ".png" ) );
			}
			// Importa as imagens dos jogadores
			this.player_imgs = new Image[num_players];
			for ( i = 0; i < num_players; i++ )
			{
				this.player_imgs[i] = ImageIO.read( new File( "src/java/data/pinos/pin" + i + ".png" ) );
			}
		}
		catch ( final IOException e )
		{
			e.printStackTrace();
			System.exit( 1 );
		}
	}

	@Override
	public void mouseClicked( final MouseEvent e )
	{
	}

	@Override
	public void mouseEntered( final MouseEvent e )
	{
	}

	@Override
	public void mouseExited( final MouseEvent e )
	{
	}

	// Tratador de Eventos do Mouse
	@Override
	public void mousePressed( final MouseEvent e )
	{
		final int x = e.getX(), y = e.getY();

		System.out.printf( "x = %d\ny = %d\n", x, y );

	}

	@Override
	public void mouseReleased( final MouseEvent e )
	{
	}

	@Override
	public void paintComponent( final Graphics g )
	{
		super.paintComponent( g );
		final Graphics2D g2d = ( Graphics2D ) g;

		import_images();
		draw_basic_board( g2d );
		drawPlayers( g2d );

	}

	public void nofityBoardPosition(Integer boardPosition,  Integer playerId)
	{
		this.playerPositions.set(playerId, boardPosition);
	}

    //public void notifyFreeRide(boolean freeRide,  Integer playerId);
    public void notifyMoney(Long money,  Integer playerId)
	{
		this.playerMoney.set(playerId, money);
	}

    public void notifyPrisionTime(Integer prisionTime,  Integer playerId)
	{
		this.prisionTimes.set(playerId, prisionTime);
	}

	@Override
	public void notifyNumPlayers(Integer numPlayers) {
		// TODO Auto-generated method stub
	}

	private Image background_img, board_img;

	private Image[] card_imgs = new Image[30];

	private Image[] company_imgs = new Image[6];

	private Image[] dice_imgs = new Image[6];

	private Image[] player_imgs;

	private Image[] property_imgs = new Image[22];

	private List<Integer> playerPositions;

	private List<Long> playerMoney;

	private List<Integer> prisionTimes;

}
