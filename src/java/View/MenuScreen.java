package View;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

import Controller.MenuController;

class MenuScreen extends JPanel implements MouseListener {
    private static int window_width;
    private static int window_height;
    private static boolean new_game = false;

    private static MenuScreen menu_screen = null;

    
    private MenuScreen (int w, int h) {
        MenuScreen.window_width = w;
        MenuScreen.window_height = h;
        addMouseListener(this);
    }
    
    public static MenuScreen getInstance(int w, int h) {
        if (menu_screen == null) {
            menu_screen = new MenuScreen(w, h);
        }
        return menu_screen;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Font header_font, gamemode_font;
        header_font = new Font("SansSerif", Font.BOLD, 25);
        gamemode_font = new Font("SansSerif", Font.BOLD, 18);

        draw_images(g2d);

        if (!new_game) {
            draw_startgame_options(g2d, header_font, gamemode_font);
        }
        else {
            draw_numplayers_options(g2d, header_font, gamemode_font);
        }

      

    }

    private void draw_startgame_options (Graphics2D g2d, Font header_font, Font gamemode_font) {
        draw_alligned_header(g2d, "Começar jogo:", header_font, Color.WHITE, 140);
        Rectangle2D rect2 = new Rectangle2D.Double(712, 170, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect2);
        Rectangle2D rect3 = new Rectangle2D.Double(712, 250, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect3);

        draw_str_in_rect(g2d, "Novo Jogo", gamemode_font, Color.BLACK, rect2);    
        draw_str_in_rect(g2d, "Carregar Jogo", gamemode_font, Color.BLACK, rect3); 
    }

    private void draw_numplayers_options(Graphics2D g2d, Font header_font, Font gamemode_font) {
        draw_alligned_header(g2d, "Novo Jogo:", header_font, Color.WHITE, 140);
        Rectangle2D rect2 = new Rectangle2D.Double(712, 170, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect2);
        Rectangle2D rect3 = new Rectangle2D.Double(712, 250, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect3);
        Rectangle2D rect4 = new Rectangle2D.Double(712, 330, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect4);
        Rectangle2D rect5 = new Rectangle2D.Double(712, 410, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect5);
        Rectangle2D rect6 = new Rectangle2D.Double(712, 490, 220, 50);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect6);

        draw_str_in_rect(g2d, "2 Jogadores", gamemode_font, Color.BLACK, rect2);    
        draw_str_in_rect(g2d, "3 Jogadores", gamemode_font, Color.BLACK, rect3);    
        draw_str_in_rect(g2d, "4 Jogadores", gamemode_font, Color.BLACK, rect4);    
        draw_str_in_rect(g2d, "5 Jogadores", gamemode_font, Color.BLACK, rect5);    
        draw_str_in_rect(g2d, "6 Jogadores", gamemode_font, Color.BLACK, rect6);    

    }

    private void draw_images(Graphics g) {
        Image img_background, img_box;
        try {
            img_background = ImageIO.read(new File("src/java/data/background.png"));
            img_box = ImageIO.read(new File("src/java/data/box.png"));
            g.drawImage(img_background, 0, 0, null);
            g.drawImage(img_box, 37, (window_height - img_box.getHeight(null))/2, null);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void draw_alligned_header (Graphics g, String str, Font font, Color cor, int height) {
        FontMetrics metrics = g.getFontMetrics(font);
        g.setFont(font);
        g.setColor(cor);
        g.drawString(str, 37 + 3*(window_width - metrics.stringWidth(str))/4, height); 
    }

    private void draw_str_in_rect (Graphics g, String str, Font font, Color cor, Rectangle2D rect) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x, y;
        x = (int)rect.getX() + ((int)rect.getWidth() - metrics.stringWidth(str))/2;
        y = (int)rect.getY() + (((int)rect.getHeight() - metrics.getHeight())/2) + metrics.getAscent();
        g.setFont(font);
        g.setColor(cor);
        g.drawString(str, x, y); 
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();

        System.out.printf("x = %d\ny = %d\n", x, y);

        if (new_game == true) { 
            if (x >= 712 && x <= 712 + 220) {
                if (y >= 170 && y <= 170 + 50){
                    MenuController.getInstance().set_num_players(2);
                }
                else if (y >= 250 && y <= 250 + 50){
                    MenuController.getInstance().set_num_players(3);
                }
                else if (y >= 330 && y <= 330 + 50){
                    MenuController.getInstance().set_num_players(4);
                }
                else if (y >= 410 && y <= 410 + 50){
                    MenuController.getInstance().set_num_players(5);
                }
                else if (y >= 490 && y <= 490 + 50){
                    MenuController.getInstance().set_num_players(6);
                }
            }
        }
        else {
            if (x >= 712 && x <= 712 + 220) {
                if (y >= 170 && y <= 170 + 50){
                    new_game = true;
                    repaint();
                }
                // else if (y >= 250 && y <= 250 + 50){
                   
                // }
            }    
        }       
    }

    public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}    
}
