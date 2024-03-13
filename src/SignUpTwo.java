import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SignUpTwo extends JFrame implements ActionListener{

    
    JTextField nameTextField,fnameTextField,mailTextField,aadhar,pan,stateTextField,pinTextField;
    JRadioButton SrYes,SrNo,ExYes,ExNo;
    JButton next;
    JComboBox religion,category,income,education,occupation;
    String formno;

    SignUpTwo(String formno)
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);

        JLabel formNo  = new JLabel("Application Form No. "+formno);
        formNo.setFont(new Font("Raleway" , Font.BOLD ,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);
        
        JLabel additionalDetail  = new JLabel("Page 2 : Additional Detail");
        additionalDetail.setFont(new Font("Raleway" , Font.BOLD ,22));
        additionalDetail.setBounds(290,80,400,30);
        add(additionalDetail);

        JLabel name  = new JLabel("Religion: ");
        name.setFont(new Font("Raleway" , Font.BOLD ,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[]={"","Hindu","Muslim","christion","Sikh","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname  = new JLabel("Category: ");
        fname.setFont(new Font("Raleway" , Font.BOLD ,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valCategory[]={"","General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob  = new JLabel("Income: ");
        dob.setFont(new Font("Raleway" , Font.BOLD ,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String valIncome[]={"","NULL","< 1,50,000","< 2,50,000","< 5,00,000","upto 10 Lacs"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender  = new JLabel("Educational");
        gender.setFont(new Font("Raleway" , Font.BOLD ,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel mail  = new JLabel("Qualification: ");
        mail.setFont(new Font("Raleway" , Font.BOLD ,20));
        mail.setBounds(100,315,200,30);
        add(mail);

        String valEducation[]={"","Graduate","Post-Graduate","12th","10th","Other"};
        education=new JComboBox(valEducation);
        education.setBounds(300,300,400,30);
        add(education);

        JLabel marital  = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway" , Font.BOLD ,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String valOccupation[]={"","Govenment Job","Private Job","Self Employed","Agriculture","Other"};
        occupation=new JComboBox(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address  = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway" , Font.BOLD ,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city  = new JLabel("Aadhar Number: ");
        city.setFont(new Font("Raleway" , Font.BOLD ,20));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state  = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway" , Font.BOLD ,20));
        state.setBounds(100,540,200,30);
        add(state);

        SrYes=new JRadioButton("Yes");
        SrYes.setBounds(300,540,60,30);
        SrYes.setBackground(Color.WHITE);
        add(SrYes);

        SrNo=new JRadioButton("No");
        SrNo.setBounds(450,540,60,30);
        SrNo.setBackground(Color.WHITE);
        add(SrNo);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(SrYes);
        gendergroup.add(SrNo);
        

        JLabel pincode  = new JLabel("Exisiting Account: ");
        pincode.setFont(new Font("Raleway" , Font.BOLD ,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        ExYes=new JRadioButton("Yes");
        ExYes.setBounds(300,590,60,30);
        ExYes.setBackground(Color.WHITE);
        add(ExYes);

        ExNo=new JRadioButton("No");
        ExNo.setBounds(450,590,60,30);
        ExNo.setBackground(Color.WHITE);
        add(ExNo);

        ButtonGroup ExisitingAccountgroup=new ButtonGroup();
        ExisitingAccountgroup.add(ExYes);
        ExisitingAccountgroup.add(ExNo);


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

        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();

        String saadhar=aadhar.getText();
        String span=pan.getText();

        String siniorCitizen=null;
        if(SrYes.isSelected()){
            siniorCitizen="Yes";
        } else if(SrNo.isSelected()) {
            siniorCitizen="No";
        }

        String existingAccount=null;
        if(ExYes.isSelected()){
            existingAccount="Yes";
        } else if(ExNo.isSelected()) {
            existingAccount="No";
        }

        

        // show validate or note
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null, "Select your Religion");
            }else if(scategory.equals("")){
                JOptionPane.showMessageDialog(null, "Select your Category");
            }else if(sincome.equals("")){
                JOptionPane.showMessageDialog(null, "Select your Income");
            }else if(seducation.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your Educational Qualification");
            }else if(soccupation.equals("")){
                JOptionPane.showMessageDialog(null, "Select your Occupation");
            }else if(saadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your Aadhar Number");
            }else if(span.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your Pan Number");
            }else if(siniorCitizen ==null){
                JOptionPane.showMessageDialog(null, "Select your Citizenship");
            }else if(existingAccount== null){
                JOptionPane.showMessageDialog(null, "Select 'you have Existing Account'");
            }else{
                System.out.println(formno+" "+sreligion +" "+ scategory+" "+ sincome+" "+seducation +" "+soccupation +" "+ saadhar+" "+span+" "+siniorCitizen+" "+existingAccount);
                Conn c=new Conn();
                String  query="insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+saadhar+"','"+span+"','"+siniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);
                
            }
            

        }catch(Exception ee)
        {
            System.out.println(ee);
        }


    }

    public static void main(String[ ] args) {
        new SignUpTwo("");
    }
}
