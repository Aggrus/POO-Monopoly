package View;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

import Controller.GameController;

class GameScreen extends JPanel implements MouseListener {
    private static int window_width;
    private static int window_height;
    private static int num_players;
    private Image background_img, board_img;
    private Image[] dice_imgs= new Image[6];
	private Image[] card_imgs = new Image[30];
	private Image[] property_imgs = new Image[22];
	private Image[] company_imgs = new Image[6];
	private Image[] player_imgs;

    private static GameScreen game_screen = null;

    private GameScreen (int w, int h, int numPLayers) {
        GameScreen.window_width = w;
        GameScreen.window_height = h;
        GameScreen.num_players = numPLayers;
        addMouseListener(this);
    }

    public static GameScreen getInstance(int w, int h, int numPLayers) {
        if (game_screen == null) {
            game_screen = new GameScreen(w, h, numPLayers);
        }
        return game_screen;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        import_images();
        draw_basic_board(g2d);



    }    

    // Importa as imagens que serão utilizadas ao longo do jogo
    private void import_images() {
        int i;
        try {
            // Importa a imagem do background    
            background_img = ImageIO.read(new File("src/java/data/background.png"));
            // Importa a imagem do tabuleiro    
            board_img = ImageIO.read(new File("src/java/data/tabuleiro.png"));
		    // Importa as imagens dos dados
            for (i = 0; i < 6; i++) {              
                dice_imgs[i] = ImageIO.read(new File("src/java/data/dados/die_face_" + (i + 1) + ".png"));
            }
		    // Importa as imagens das cartas
            for (i = 0; i < 30; i++) {
                card_imgs[i] = ImageIO.read(new File("src/java/data/sorteReves/chance" + (i + 1) + ".png"));	
            }
            // Importa as imagens das propriedades
            for (i = 0; i < 22; i++) {
                property_imgs[i] = ImageIO.read(new File("src/java/data/territorios/territory" + (i + 1) + ".png"));	
            }
            // Importa as imagens das companhias
            for (i = 0; i < 6; i++) {
                company_imgs[i] = ImageIO.read(new File("src/java/data/companhias/company" + (i + 1) + ".png"));	
            }
            //Importa as imagens dos jogadores
            player_imgs = new Image[num_players];
            for (i = 0; i < num_players; i++) {
                player_imgs[i] = ImageIO.read(new File("src/java/data/pinos/pin" + i + ".png"));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    
    // Desenha o Tabuleiro e o Background na tela
    private void draw_basic_board (Graphics g) {
            g.drawImage(background_img, 0, 0, null);
            g.drawImage(board_img, 17, (window_height - 90*board_img.getHeight(null)/100)/4, 90*board_img.getWidth(null)/100, 90*board_img.getWidth(null)/100, null);
    }

    // Tratador de Eventos do Mouse
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();

        System.out.printf("x = %d\ny = %d\n", x, y);

    }

    public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}