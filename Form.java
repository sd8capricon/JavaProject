import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class Form extends JFrame implements ActionListener {
    JLabel nameL, mobileL, genderL, dobL, addressL, msgL;
    JTextField nameTF, mobileTF;
    JTextArea addressTA, dispTA;
    JRadioButton maleRB, femaleRB;
    JComboBox dayCB, monthCB, yearCB;
    JCheckBox termsChB;
    JButton submitB;

    String days[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" };
    String years[] = { "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014" };

    Form() {
        setTitle("Registration Form");
        setSize(700, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Name Section
        nameL = new JLabel("Name");
        nameL.setBounds(20, 50, 100, 20);
        add(nameL);

        nameTF = new JTextField();
        nameTF.setBounds(130, 50, 100, 20);
        add(nameTF);

        // Contact Section
        mobileL = new JLabel("Mobile");
        mobileL.setBounds(20, 100, 100, 20);
        add(mobileL);

        mobileTF = new JTextField();
        mobileTF.setBounds(130, 100, 100, 20);
        add(mobileTF);

        // Gender Section
        genderL = new JLabel("Gender");
        genderL.setBounds(20, 150, 100, 20);
        add(genderL);

        maleRB = new JRadioButton("Male");
        femaleRB = new JRadioButton("Female");
        maleRB.setBounds(130, 150, 80, 20);
        femaleRB.setBounds(220, 150, 100, 20);
        add(maleRB);
        add(femaleRB);

        ButtonGroup gen = new ButtonGroup();
        gen.add(maleRB);
        gen.add(femaleRB);

        // DOB Section
        dobL = new JLabel("DOB");
        dobL.setBounds(20, 200, 100, 20);
        add(dobL);

        dayCB = new JComboBox(days);
        monthCB = new JComboBox(months);
        yearCB = new JComboBox(years);
        dayCB.setBounds(130, 200, 50, 20);
        monthCB.setBounds(190, 200, 50, 20);
        yearCB.setBounds(250, 200, 60, 20);
        add(dayCB);
        add(monthCB);
        add(yearCB);

        // Address Section
        addressL = new JLabel("Address");
        addressL.setBounds(20, 250, 100, 20);
        add(addressL);

        addressTA = new JTextArea();
        addressTA.setBounds(130, 240, 200, 50);
        add(addressTA);

        // Terms Section
        termsChB = new JCheckBox("Please Accept Terms and Condition");
        termsChB.setBounds(50, 300, 250, 20);
        add(termsChB);

        // Submit Button
        submitB = new JButton("Submit");
        submitB.setBounds(150, 350, 80, 20);
        submitB.addActionListener(this);
        add(submitB);

        // Display Area
        dispTA = new JTextArea();
        dispTA.setBounds(350, 50, 300, 300);
        add(dispTA);

        // MSG
        msgL = new JLabel("");
        msgL.setBounds(2, 400, 250, 20);
        add(msgL);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (termsChB.isSelected()) {
            String name = nameTF.getText();
            String num = mobileTF.getText();
            String gender = femaleRB.isSelected() ? "Female" : "Male";
            String dob = dayCB.getSelectedItem() + "-" + monthCB.getSelectedItem() + "-" + yearCB.getSelectedItem();
            String address = addressTA.getText();
            
            String data = "Name: " + name + "\nMobile Number: " + num + "\nGender: " + gender + "\nDOB: " + dob
                    + "\nAddress: " + address;
            dispTA.setText(data);
            
            try {
                File file = new File(num + ".txt"); // Using mobile number as unique identifier
                if (file.createNewFile()) {
                    try {
                        FileWriter fw = new FileWriter(num + ".txt");
                        fw.write(data);
                        fw.close();
                        msgL.setText("Registration Successful");
                    } catch (Exception err) {
                        System.out.println(err);
                    }
                }
                else {
                    System.out.println("File already exists.");
                    msgL.setText("User already exists!!");
                }
            } catch (Exception err) {
                System.out.println(err);
            }
        } else {
            msgL.setText("Please Accept Terms and Condition");
        }
    }

    public static void main(String[] args) {
        new Form();
    }
}