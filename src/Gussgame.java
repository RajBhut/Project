import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.util.Random;

public class Gussgame extends JFrame {
    private JTextField gussfield;
    private JLabel gusslable, warning;
    private JButton enter;
    private int q;
    private boolean isgusspass = false;

    Gussgame() {
        JFrame GG = new JFrame("Main");
        GG.setSize(400, 500);
        GG.setLayout(null);
        GG.setDefaultCloseOperation(EXIT_ON_CLOSE);

        gussfield = new JTextField();
        gussfield.setBounds(120, 80, 200, 25);
        GG.add(gussfield);

        gusslable = new JLabel("Enter guess:");
        gusslable.setHorizontalAlignment(SwingConstants.CENTER);
        gusslable.setBounds(20, 70, 100, 50);
        GG.add(gusslable);

        warning = new JLabel("Invalid input");
        warning.setBounds(160, 250, 100, 50);
        warning.setVisible(false);
        GG.add(warning);

        enter = new JButton("Enter");
        enter.setBounds(150, 150, 100, 50);
        enter.setFocusable(false);
        GG.add(enter);

        enter.addActionListener((e -> {
            String input = gussfield.getText();
            try {
                q = Integer.parseInt(input);
                if (q > 11 || q < 0) {
                    warning.setText("Enter a number between 0 and 11");
                    warning.setVisible(true);
                    gussfield.setText("");
                } else {
                    isgusspass = true;
                    GG.setVisible(false);
                    playGame();
                }
            } catch (NumberFormatException ex) {
                warning.setText("Invalid input. Enter a number.");
                warning.setVisible(true);
                gussfield.setText("");
            }
        }));

        GG.setVisible(true);
    }

    private void playGame() {
        Random que = new Random();
        int num = que.nextInt(101);
        int attempts = q;

        while (attempts > 0) {
            try {
                int ans = Integer.parseInt(JOptionPane.showInputDialog("Enter your guess:"));

                if (ans == num) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
                    //System.exit(0);
					  Main_Manue manue3 = new Main_Manue();
                    break;
                } else if (ans < num) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
                }

                attempts--;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }

        if (attempts == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, you have used all your attempts. The correct number was: " + num);
       //System.exit(0);
            Main_Manue manue = new Main_Manue();

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gussgame());
    }
}
