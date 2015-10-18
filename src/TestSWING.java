import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TestSWING {


    public static void main(String... args) {


        JFrame frame = new JFrame("SnakeGame");

//        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new GridBagLayout());


//        frame.setBackground(Color.YELLOW);

        final JLabel loginLabel = new JLabel("Login:");
        final JLabel passwordLabel = new JLabel("Password:");
        final JButton  btnLogin= new JButton("login in");
        final JButton  btnRegistration= new JButton("Registration");
        final JTextField loginField = new JTextField(15);
        final JPasswordField psdField = new JPasswordField(15);

        frame.add(loginLabel, new GridBagConstraints(
                0, 0, 1, 1, 0.1, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0,0,0,0), 0, 0));
        frame.add(loginField, new GridBagConstraints(
                1, 0, 1, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0,0,0,0), 0, 0));

        frame.add(passwordLabel, new GridBagConstraints(
                0, 1, 1, 1, 0.1, 0.1,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0,0,0,0), 0, 0));
        frame.add(psdField, new GridBagConstraints(
                1, 1, 1, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0,0,0,0), 0, 0));

        frame.add(btnLogin, new GridBagConstraints(
                0, 2, 2, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0), 95, 0));
        frame.add(btnRegistration, new GridBagConstraints(
                1, 3, 1, 1, 0.1, 0.1,
                GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(0,0,0,0), 50, 0));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loginField.getText());
            }
        });




    }
}