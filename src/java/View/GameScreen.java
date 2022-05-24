package View;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

class GameScreen extends JPanel implements MouseListener {
    private static int window_width;
    private static int window_height;

    private static GameScreen game_screen = null;

    private GameScreen (int w, int h) {
        GameScreen.window_width = w;
        GameScreen.window_height = h;
        addMouseListener(this);
    }

    public static GameScreen getGameScreen(int w, int h) {
        if (game_screen == null) {
            game_screen = new GameScreen(w, h);
        }
        return game_screen;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        draw_images(g2d);



    }    

    private void draw_images(Graphics g) {
        Image img_background, img_board;
        try {
            img_background = ImageIO.read(new File("data/background.png"));
            img_board = ImageIO.read(new File("data/tabuleiro.png"));
            g.drawImage(img_background, 0, 0, null);
            g.drawImage(img_board, 17, (window_height - 90*img_board.getHeight(null)/100)/4, 90*img_board.getWidth(null)/100, 90*img_board.getWidth(null)/100, null);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
    
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();

        System.out.printf("x = %d\ny = %d\n", x, y);

    }

    public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}