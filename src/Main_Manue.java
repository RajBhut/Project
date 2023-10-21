import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main_Manue extends JFrame {


JButton Gussgame = new JButton("Guss Number");
JButton Counter = new JButton("Counter");
    Main_Manue()
    {
        JFrame mainfram = new JFrame("Manue");
        mainfram.setLayout(null);
        mainfram.setSize(600,500);
        mainfram.add(Gussgame);

        Gussgame.setFocusable(false);
        Counter.setFocusable(false);
        Counter.setBounds(350,50,200,100);
        mainfram.add(Counter);
        Gussgame.setBounds(20,50,200,100);
        mainfram.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Gussgame.addActionListener((e -> {

            Gussgame g = new Gussgame();
            mainfram.setVisible(false);


        }));
        Counter.addActionListener((e -> {

            Counter_class g = new Counter_class();
            mainfram.setVisible(false);


        }));


mainfram.setVisible(true);
    }
}
