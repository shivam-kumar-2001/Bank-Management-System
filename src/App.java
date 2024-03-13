import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;


public class App extends JFrame implements ActionListener{

    JTextField cardText;
    JButton clearText,login,signIn;
    JPasswordField pinText;
    App()
    {
        setTitle("Automated Teller Machine");
        setLayout(null);

        // add icon image on frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);




        // add text on frame
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No. :");
        cardno.setFont(new Font("raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        // textField of cardNo.
        cardText=new JTextField();
        cardText.setBounds(300,150,250,30);
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        add(cardText);

        JLabel pin=new JLabel("Pin : ");
        pin.setFont(new Font("raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        // textField of PIN.
        pinText=new JPasswordField();
        pinText.setBounds(300,220,250,30);
        pinText.setFont(new Font("Arial",Font.BOLD,20));
        add(pinText);

        // Button for sign in.
        signIn = new JButton("SIGN IN");
        signIn.setBounds(300,300,100,30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);

        // Button for Clear.
        clearText = new JButton("CLEAR");
        clearText.setBounds(450,300,100,30);
        clearText.setBackground(Color.BLACK);
        clearText.setForeground(Color.WHITE);
        clearText.addActionListener(this);
        add(clearText);

        // Button for Login.
        login = new JButton("LOGIN");
        login.setBounds(300,350,250,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);



        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==clearText){
            cardText.setText("");
            pinText.setText("");
        }else if (ae.getSource() == signIn) {
            setVisible(false);
            new SignUpOne().setVisible(true);
           
        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardText.getText();
            String pinnumber=pinText.getText(); 

            try{
                if(cardnumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Card number");
                }else if(pinnumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Pin number");
                }
            }catch(Exception e){
                System.out.println(e);
            }

            String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"';";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                System.out.println(rs);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber) .setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin.");
                }

            }catch(Exception e){
                System.out.println(e);
            }

        }
    }
    
    public static void main(String[] args){
        new App();
    }
}
