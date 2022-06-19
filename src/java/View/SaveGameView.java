package View;

import java.io.File;

import javax.swing.JFileChooser;

public class SaveGameView {
    public static void loadGame()
    {
        JFileChooser saveFile = new JFileChooser();
        Integer response = saveFile.showOpenDialog(null);

        if (response.equals(JFileChooser.APPROVE_OPTION))
        {
            File fileChosen = saveFile.getSelectedFile();
            String filePath = fileChosen.getAbsolutePath();
            
        }
    }
}
