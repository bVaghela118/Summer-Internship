import java.awt.*;
import javax.swing.*;
public class ContainerDemo extends JFrame{
    JPanel panel;
    JTextField field;
    JButton btn;
    public ContainerDemo()
    {
        setTitle("Container Demo");
        panel = new JPanel();
        field = new JTextField(25);
        panel.add(field);
        btn = new JButton("Submit");
        panel.add(btn);
        add(panel,BorderLayout.CENTER);
        setSize(300,225);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }    

    public static void main(String args[])
    {
        new ContainerDemo();
    }
}
