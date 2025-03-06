import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class CustomerAdditionalInfo extends JFrame implements ActionListener {

    JTextField tin, ssn;
    JButton next;
    JRadioButton seniorYes, seniorNo, accountYes, accountNo;
    JComboBox<String> religion, accountType, income, education, occupation;

    String formnum;

    CustomerAdditionalInfo(String formnum) {
        this.formnum = formnum;
        setLayout(null);
        setTitle("CUSTOMER ADDITIONAL INFO - PAGE 2");

        // Header
        JLabel header = new JLabel("Page 2: Additional Info");
        header.setFont(new Font("Raleway", Font.BOLD, 38));
        header.setBounds(140, 20, 600, 40);
        add(header);

        // Religion
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 200, 30);
        add(religionLabel);

        String[] religions = {"Christianity", "Hinduism", "Judaism", "Islam", "Buddhism", "Other"};
        religion = new JComboBox<>(religions);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        // Account Type
        JLabel categoryTypeLabel = new JLabel("Account Type:");
        categoryTypeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryTypeLabel.setBounds(100, 190, 200, 30);
        add(categoryTypeLabel);

        String[] accountTypes = {"Savings Account", "Checking Account", "Fixed Deposit", "Recurring Deposit", "Joint Account", "Student Account", "Other"};
        accountType = new JComboBox<>(accountTypes);
        accountType.setBounds(300, 190, 400, 30);
        accountType.setBackground(Color.WHITE);
        add(accountType);

        // Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String[] incomes = {"Null", "< 10,000", "10,000 - 30,000", "30,000 - 100,000", "100,000+"};
        income = new JComboBox<>(incomes);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        // Education
        JLabel educationLabel = new JLabel("Education:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        String[] educationLevels = {"High School", "Associate Degree", "Bachelor's Degree", "Master's Degree", "Doctorate"};
        education = new JComboBox<>(educationLevels);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        // Occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 340, 200, 30);
        add(occupationLabel);

        String[] occupations = {"Self-Employed", "Salaried", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox<>(occupations);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        // Tax Identification Number
        JLabel tinLabel = new JLabel("Tax Identification Number (TIN):");
        tinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        tinLabel.setBounds(100, 390, 300, 30);
        add(tinLabel);

        tin = new JTextField();
        tin.setBounds(300, 390, 400, 30);
        tin.setFont(new Font("Raleway", Font.BOLD, 14));
        add(tin);

        // Social Security Number
        JLabel ssnLabel = new JLabel("Social Security Number (SSN):");
        ssnLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        ssnLabel.setBounds(100, 440, 300, 30);
        add(ssnLabel);

        ssn = new JTextField();
        ssn.setBounds(300, 440, 400, 30);
        ssn.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ssn);

        // Senior Citizen
        JLabel seniorLabel = new JLabel("Senior Citizen:");
        seniorLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorLabel.setBounds(100, 490, 200, 30);
        add(seniorLabel);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300, 490, 100, 30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(400, 490, 100, 30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        // Existing Account
        JLabel accountLabel = new JLabel("Existing Account:");
        accountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        accountLabel.setBounds(100, 540, 200, 30);
        add(accountLabel);

        accountYes = new JRadioButton("Yes");
        accountYes.setBounds(300, 540, 100, 30);
        accountYes.setBackground(Color.WHITE);
        add(accountYes);

        accountNo = new JRadioButton("No");
        accountNo.setBounds(400, 540, 100, 30);
        accountNo.setBackground(Color.WHITE);
        add(accountNo);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(accountYes);
        accountGroup.add(accountNo);

        // Next Button
        next = new JButton("Next");
        next.setBounds(620, 600, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 750);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String selectedReligion = (String) religion.getSelectedItem();
        String selectedAccountType = (String) accountType.getSelectedItem();
        String selectedIncome = (String) income.getSelectedItem();
        String selectedEducation = (String) education.getSelectedItem();
        String selectedOccupation = (String) occupation.getSelectedItem();

        String seniorStatus = seniorYes.isSelected() ? "Yes" : "No";
        String existingAccount = accountYes.isSelected() ? "Yes" : "No";

        String tinValue = tin.getText();
        String ssnValue = ssn.getText();

        try {
            if (tinValue.isEmpty() || ssnValue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
            } else {
            }
            Connect c = new Connect();
            String query = "INSERT INTO CustomerAdditionalInfo (formnum, religion, accountType, income, education, occupation, tin, ssn, seniorCitizen, existingAccount) VALUES ('"
                    + formnum + "', '"
                    + selectedReligion + "', '"
                    + selectedAccountType + "', '"
                    + selectedIncome + "', '"
                    + selectedEducation + "', '"
                    + selectedOccupation + "', '"
                    + tinValue + "', '"
                    + ssnValue + "', '"
                    + seniorStatus + "', '"
                    + existingAccount + "')";
            c.st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred." + e.getMessage());
        }
    }
    public  static void main(String[] args) {

        new CustomerAdditionalInfo("").setVisible(true);
    }

}
