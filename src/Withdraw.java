import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;

    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw=new JButton("withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
            if(ae.getSource()==withdraw){
                String number=amount.getText();
                Date d1=new Date();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To withdraw.");
                }else{
                    try{
                        Conn conn=new Conn();
                        ResultSet rs = conn.s.executeQuery("select * from bank where PIN='"+pinnumber+"'");
                        int balance=0;
                        while (rs.next()) {
                            if(rs.getString("type").equals("Deposite")){
                                balance += Integer.parseInt(rs.getString("amount"));
                            }else if(rs.getString("type").equals("withdraw")){
                                balance -= Integer.parseInt(rs.getString("amount"));
                            }
                        }

                        if(balance<Integer.parseInt(number)){
                            JOptionPane.showMessageDialog(null,"Your Balance is Low.\nYou can not Withdraw this amount.\n");
                        }else{

                            String query="insert into bank values('"+pinnumber+"','"+d1+"','withdraw','"+number+"')";
                            conn.s.executeUpdate(query);

                            JOptionPane.showMessageDialog(null,"Rs. " + number + " Withdraw Successfully");
                            setVisible(false);
                            new Transaction(pinnumber).setVisible(true);

                        }
                        
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
        new Withdraw("");
    }

    
    
}
