import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Image;

public class PinChange extends JFrame implements ActionListener{

    JButton change ,back;
    JPasswordField pin,repin;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text=new JLabel("Change Your Pin");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        image.add(text);


        JLabel newPin=new JLabel("New Pin:");
        newPin.setFont(new Font("System",Font.BOLD,16));
        newPin.setBounds(165,320,180,25);
        newPin.setForeground(Color.WHITE);
        image.add(newPin);

        pin =new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);


        
        JLabel renewPin=new JLabel("Re-Enter New Pin:");
        renewPin.setFont(new Font("System",Font.BOLD,16));
        renewPin.setBounds(165,360,180,25);
        renewPin.setForeground(Color.WHITE);
        image.add(renewPin);

        repin =new JPasswordField();
        repin.setFont(new Font("System",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change=new JButton("Change");
        change.setFont(new Font("System",Font.BOLD,25));
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setFont(new Font("System",Font.BOLD,25));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        // setUndecorated(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            try {
                String npin=pin.getText();
                String rpin=repin.getText();
                if(npin.equals("") ){
                    JOptionPane.showMessageDialog(null,"Please Enter new Pin");
                }else if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter new Pin");
                }else if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enter Pin  and Re-Enter Pin are not the Same!");
                }else{
                    Conn c=new Conn();
                    String q1="update bank set pin= '"+rpin+"' where pin='"+pinnumber+"'";
                    String q2="update signupthree set Pin_Number= '"+rpin+"' where Pin_Number='"+pinnumber+"'";  
                    String q3="update login set pin= '"+rpin+"' where pin='"+pinnumber+"'";

                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null,"Pin change Successful");
                    setVisible(false);
                    new Transaction(rpin).setVisible(true);
               
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }



    
}
