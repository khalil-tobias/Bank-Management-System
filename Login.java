import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {

    JButton login, signUp, clear;
    JTextField t1;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image image2 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon (image2);
        JLabel label = new JLabel(icon2);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel l1 = new JLabel("Welcome to ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,400,40);
        add(l1);

        JLabel l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(120,150,400,40);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(300,150,250,30);
        t1.setFont(new Font("Arial", Font.BOLD, 14));
        add(t1);


        JLabel l3 = new JLabel("Enter PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(120,220,230,30);
        add(l3);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("clear");
        clear.setBounds(300,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(300,350,230,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            t1.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){

        }
        else if(ae.getSource() == signUp){
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
