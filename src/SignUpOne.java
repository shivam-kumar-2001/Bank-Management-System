import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField,fnameTextField,mailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;

    SignUpOne()
    {
        setTitle("Signup Page");
        setLayout(null);

        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formNo  = new JLabel("Application Form No. "+random);
        formNo.setFont(new Font("Raleway" , Font.BOLD ,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);
        
        JLabel personalDetail  = new JLabel("Page 1 : Personal Detail");
        personalDetail.setFont(new Font("Raleway" , Font.BOLD ,22));
        personalDetail.setBounds(290,80,400,30);
        add(personalDetail);

        JLabel name  = new JLabel("Name: ");
        name.setFont(new Font("Raleway" , Font.BOLD ,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname  = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway" , Font.BOLD ,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob  = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway" , Font.BOLD ,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser=new JDateChooser() ;
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender  = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway" , Font.BOLD ,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel mail  = new JLabel("Gmail: ");
        mail.setFont(new Font("Raleway" , Font.BOLD ,20));
        mail.setBounds(100,340,200,30);
        add(mail);

        mailTextField=new JTextField();
        mailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        mailTextField.setBounds(300,340,400,30);
        add(mailTextField);

        JLabel marital  = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway" , Font.BOLD ,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup marriedgroup=new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(other);

        JLabel address  = new JLabel("Address: ");
        address.setFont(new Font("Raleway" , Font.BOLD ,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city  = new JLabel("City: ");
        city.setFont(new Font("Raleway" , Font.BOLD ,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state  = new JLabel("State: ");
        state.setFont(new Font("Raleway" , Font.BOLD ,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode  = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway" , Font.BOLD ,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);


        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setSize(850,800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String formno=""+ random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        } else if(female.isSelected()) {
            gender="Female";
        }

        String email=mailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }

        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String pin=pinTextField.getText();
        String state=stateTextField.getText();

        // show validate or note
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your name");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your father name");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your DOB");
            }else if(gender==null){
                JOptionPane.showMessageDialog(null, "Select your gender");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your email");
            }else if(marital== null){
                JOptionPane.showMessageDialog(null, "Select your marital status");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your address");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your pincode");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your city");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your state");
            }else{
                Conn c=new Conn();
                String  query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
                
            }
            

        }catch(Exception ee)
        {
            System.out.println(ee);
        }


    }

    public static void main(String[ ] args) {
        new SignUpOne();
    }
}
