import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener{
    JButton deposite,back;
    JTextField amount;
    String pinnumber;

    Deposite(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text=new JLabel("Enter The Amount You Want To Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposite=new JButton("Deposite");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        back=new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        // setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==deposite){
                String number=amount.getText();
                Date d1=new Date();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To Deposit.");
                }else{
                    try{
                        Conn conn=new Conn();
                        String query="insert into bank values('"+pinnumber+"','"+d1+"','Deposite','"+number+"')";
                        conn.s.executeUpdate(query);

                        JOptionPane.showMessageDialog(null,"Rs. "+number+" Deposited Successfully");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                

                }

            }else if(ae.getSource()==back){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
         }

    public static void main(String[] args) {
        new Deposite("");
    }

    
}
