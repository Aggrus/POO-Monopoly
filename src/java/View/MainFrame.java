package View;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public final int DFLT_WIDTH = 1100;
    public final int DFLT_HEIGHT = 700;

    private static MainFrame main_frame = null;

    public MainFrame() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screen_width = screenSize.width;
        int screen_height = screenSize.height;
        int x = screen_width/2 - DFLT_WIDTH/2;
        int y = screen_height/2 - DFLT_HEIGHT/2;
        setBounds(x, y, DFLT_WIDTH, DFLT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.ScreenManager();
    }

    public static MainFrame getMainFrame() {
        if (main_frame == null) {
            main_frame = new MainFrame();
            main_frame.setTitle("Jogo Monopoly");
            main_frame.setVisible(true);
        }
        return main_frame;
    }

    public void ScreenManager () {
        int game_mode = 2;
        if (game_mode == 0) {
            getContentPane().add(MenuScreen.getMenuScreen(DFLT_WIDTH, DFLT_HEIGHT));
        }
        else {
            getContentPane().add(GameScreen.getGameScreen(DFLT_WIDTH, DFLT_HEIGHT));
        } 
    }
}
