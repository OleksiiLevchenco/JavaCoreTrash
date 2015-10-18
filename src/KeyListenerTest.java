import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;

/**
 * @author Alexey Levchhenko
 */
public class KeyListenerTest {
    public KeyListenerTest(){
        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel panel =new JPanel();
        frame.add(panel);
        panel.setFocusable(true);
        panel.addKeyListener(new KeyAdapter() {

            public void keyPressed (KeyEvent e) {
                System.out.println(e.getKeyText(e.getKeyCode()));
                    }
        });



    }

    public static void main(String[] args) {
        new KeyListenerTest();
    }
}
