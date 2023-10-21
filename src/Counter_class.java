import javax.swing.*;


public class Counter_class extends JFrame
{
    private JFrame counterfram = new JFrame("Counter");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private  JLabel dis = new JLabel("");
    private int counter = 0;

    Counter_class ()
    {
        counterfram.setSize(300,400);
        plus.setBounds(10,20,50,30);
        counterfram.add(plus);
        plus.setFocusable(false);
        minus.setFocusable(false);
        minus.setBounds(230,20,50,30);
        counterfram.add(minus);
        dis.setBounds(130,300,50,20);
        dis.setHorizontalAlignment(SwingConstants.CENTER);
        dis.setHorizontalTextPosition(SwingConstants.CENTER);
        counterfram.add(dis);
        plus.addActionListener((e -> {
            counter++;
            dis.setText(String.valueOf(counter));
        }));
        minus.addActionListener((e->
        {
            if(counter >0)
            {
                counter--;
                dis.setText(String.valueOf(counter));
            }
            else {
                JOptionPane.showMessageDialog(null, "Out of count", "warning", JOptionPane.WARNING_MESSAGE);
Main_Manue manu2 = new Main_Manue();
counterfram.setVisible(false);
            }}));
        counterfram.setDefaultCloseOperation(EXIT_ON_CLOSE);
        counterfram.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Counter_class());
    }
}
