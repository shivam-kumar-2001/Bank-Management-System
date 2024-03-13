import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{

    String pinnumber;
    JButton back;

    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel miniStatement=new JLabel();
        miniStatement.setBounds(20,140,400,200);
        add(miniStatement);


        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        bank.setFont(new Font("System",Font.BOLD,16));
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("System",Font.BOLD,10));
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20, 400, 20, HEIGHT);
        add(balance);

        back=new JButton("Back");
        back.addActionListener(this);
        back.setBounds(260,490,80,22);
        add(back);

        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next()) {
                card.setText("card Number: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
                
            }            
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            Conn c=new Conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                miniStatement.setText(miniStatement.getText()+ "<html>"+rs.getString("date")+"           "+rs.getString("type")+"            "+rs.getString("amount")+"<br><br>");
                
                if(rs.getString("type").equals("Deposite")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else if(rs.getString("type").equals("withdraw")){
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            
            balance.setText("Your Current Account Balance id Rs "+bal+"\n");


        } catch (Exception e) {
            System.out.println(e);
        }


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        // setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void  actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}