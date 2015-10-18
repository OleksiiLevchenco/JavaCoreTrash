package imageOpenDialogTest;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;


/**
 * @author Alexey Levchhenko
 */
public class ImageOpenDialogTest {

    JFrame frame;
    JLabel jLabel = new JLabel();
    JScrollPane scrollPane;
    JMenu menu;
    Image img;
    File file;

    class FileOpenActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();

            if (jFileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {

                System.out.println(jFileChooser.getSelectedFile());

                file = jFileChooser.getSelectedFile();
                try {
                    img = ImageIO.read(file); // получаем данные типа image (пиксели с координатам x y в каждом пикселе записан int = alfa - 8 bit, red - 8bit,  grin - 8bit, blue - 8bit)
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                jLabel.setIcon(new ImageIcon(jFileChooser.getSelectedFile().getPath()));
                jLabel.setHorizontalAlignment(JLabel.CENTER);
                scrollPane.getViewport().add(jLabel);

            } else System.out.println(false);
        }
    }


    public void create() {
        frame = new JFrame("SnakeGame");
        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("File");
        JMenuItem fileMenuItem = new JMenuItem("Open...");
        scrollPane = new JScrollPane();

        menu.add(fileMenuItem);
        fileMenuItem.addActionListener(new FileOpenActionListener());
        menuBar.add(menu);

        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        frame.setJMenuBar(menuBar);


        frame.add(scrollPane);

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        ImageOpenDialogTest im = new ImageOpenDialogTest();
        im.create();
    }
}
