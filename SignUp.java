import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignUp extends JFrame implements ActionListener{

    long random;
    JTextField nameField, fnameField, emailField, addressField, stateField, cityField, ZipCodeField, pinField;
    JButton next;
    JRadioButton male, female, married, divorced, single;
    JSpinner dobSpinner;
    SignUp()
    {
        setLayout(null);
        Random ran = new Random();
        long random = (Math.abs(ran.nextLong() % 9000L) + 1000L);
        JLabel formnum  = new JLabel("APPLICATION FORM NO. " + random);
        formnum.setFont(new Font("Raleway", Font.BOLD, 38));
        formnum.setBounds(140,20,600,40);
        add(formnum);

        JLabel personalDetails  = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);


        JLabel  name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);


        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameField.setBounds(300,140,400,30);
        add(nameField);



        JLabel  fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);

         fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameField.setBounds(300,190,400,30);
        add(fnameField);



        JLabel  dob = new JLabel( "Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dobSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dobSpinner, "MM-dd-yyyy");
        dobSpinner.setEditor(dateEditor);
        dobSpinner.setBounds(300,240,400,30);
        add(dobSpinner);

        JLabel  gender = new JLabel( "Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

         male = new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        male.setBackground(Color.WHITE);
        add(male);

         female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        add(female);

        JLabel  Email= new JLabel( "Email Address: ");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100,340,200,30);
        add(Email);

         emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailField.setBounds(300,340,400,30);
        add(emailField);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel  Material_Status = new JLabel( "Material Status: ");
        Material_Status.setFont(new Font("Raleway", Font.BOLD, 20));
        Material_Status.setBounds(100,390,200,30);
        add(Material_Status);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        divorced = new JRadioButton("Divorced");
        divorced.setBounds(450,390,100,30);
        divorced.setBackground(Color.WHITE);
        add(divorced);

         single = new JRadioButton("Single");
        single.setBounds(630,390,100,30);
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(divorced);
        maritalGroup.add(single);

        JLabel Address = new JLabel( "Address: ");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100,440,200,30);
        add(Address);

         addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressField.setBounds(300,440,400,30);
        add(addressField);

        JLabel city = new JLabel( "City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);

         cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityField.setBounds(300,490,400,30);
        add(cityField);

        JLabel state = new JLabel( "State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateField.setBounds(300,540,200,30);
        add(stateField);

        JLabel ZipCode = new JLabel( "Zip Code: ");
        ZipCode.setFont(new Font("Raleway", Font.BOLD, 20));
        ZipCode.setBounds(100,590,200,30);
        add(ZipCode);

        ZipCodeField = new JTextField();
        ZipCodeField.setFont(new Font("Raleway", Font.BOLD, 14));
        ZipCodeField.setBounds(300,590,400,30);
        add(ZipCodeField);

        JLabel PinNumber = new JLabel( "Pin Number: ");
        PinNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        PinNumber.setBounds(100,640,200,30);
        add(PinNumber);

         pinField = new JTextField();
        pinField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinField.setBounds(300,640,400,30);
        add(pinField);

        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String formnum  = "" + random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = dobSpinner.getValue().toString().trim();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailField.getText();
        String maritalStatus = null;
        if(married.isSelected())
        {
            maritalStatus = "Married";
        }
        else if(divorced.isSelected())
        {
            maritalStatus = "Divorced";
        } else if (single.isSelected()) {
            maritalStatus = "Single";
        }
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String zipCode = ZipCodeField.getText();
        String pinNumber = pinField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else {
                Connect c = new Connect();
                String query = "INSERT INTO signup (formnum, name, father_name, dob, gender, email, maritalStatus, address, city, state, zipcode, pinCode) VALUES ('" + formnum + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "', '" + state + "', '" + zipCode + "', '" + pinNumber + "')";
                c.st.executeUpdate(query);

                setVisible(false);
                new CustomerAdditionalInfo(formnum).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public  static void main(String[] args) {

        new SignUp();
    }
}
