import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    public SignUpThree(String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);

        JLabel l1=new JLabel("Page 3: Account Details.");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 180, 150, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 200, 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 150, 20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4125");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardDetail=new JLabel("(Your 16 Digit Card Number)");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pinDetail=new JLabel("(Your 4 Digit Password)");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);

        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raileway",Font.BOLD,16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4=new JCheckBox("SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raileway",Font.BOLD,16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raileway",Font.BOLD,16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6=new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raileway",Font.BOLD,16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);


        c7=new JCheckBox("I hereby declares thst the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 720, 100, 30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 720, 100, 30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setSize(850,820);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Reccuring  Deposit Account";
            }

            Random random=new Random();
            String cardnumber="50409365"+ Math.abs((random.nextLong() % 90000000L));
            String pinnumber=""+ Math.abs((random.nextLong() % 9000L));

            String facility="";
            if(c1.isSelected())
            {
                facility+= "ATM-Card";
            }
            if(c2.isSelected())
            {
                facility= facility +" Internet-Banking";
            }
            if(c3.isSelected()){
                facility=facility+" Mobile-Banking";
            }
            if(c4.isSelected())
            {
                facility=facility+" SMS-Alert";
            }
            if(c5.isSelected()){
                facility=facility+" Cheque-Book";
            }
            if(c6.isSelected()){
                facility=facility+" E-Statement";
            }


            try{
                if(accountType==null){
                    JOptionPane.showMessageDialog(null, "Account Type is required.");
                }else if(facility.equals("")){
                    JOptionPane.showMessageDialog(null, "Choose Facility You Want.");
                }else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please Tick The Box");

                }else{
                   
                    Conn conn=new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";  
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\nPin Number: "+pinnumber);

                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);

                    

                }

            }catch(Exception e){
                System.out.println(e);
            }


        }else if(ae.getSource()==cancel){
            setVisible(false);
            new App().setVisible(true);
        }

    }

    public static void main(String[] args){
        new SignUpThree("");
    }
    
}
