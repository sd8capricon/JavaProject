import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class Form extends JFrame implements ActionListener {
    JLabel nameL, mobileL, genderL, dobL, addressL, msgL,emailL,examL,marksL,branchL,collegeL;
    JTextField nameTF, mobileTF, emailTF,markTF;
    JTextArea addressTA, dispTA;
    JRadioButton maleRB, femaleRB;
    JComboBox dayCB, monthCB, yearCB,examCB,branchCB;
    JCheckBox termsChB;
    JButton submitB;
    

    String days[] = new String[31];
    String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" };
    String years[] = new String[50];
    int dayInit = 1;
    int yearInit = 2021;

    void initNums(){
        for (int i = 0; i < 50; i++) {
            years[i] = String.valueOf(yearInit);
            yearInit--;
        }
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(dayInit);
            dayInit++;
        }
    }

    Form() {
        initNums();
        setTitle("Student Registration Form");
        setSize(700, 900);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //College Name
        collegeL = new JLabel("DON BOSCO INSTITUTE OF TECHNOLOGY");
        collegeL.setBounds(220,50,300,30);
        add(collegeL);

        // Name Section
        nameL = new JLabel("Name");
        nameL.setBounds(20, 100, 100, 20);
        add(nameL);

        nameTF = new JTextField();
        nameTF.setBounds(130, 100, 100, 20);
        add(nameTF);

        // Contact Section
        mobileL = new JLabel("Mobile");
        mobileL.setBounds(20, 150, 100, 20);
        add(mobileL);

        mobileTF = new JTextField();
        mobileTF.setBounds(130, 150, 100, 20);
        add(mobileTF);

        // Email Section
        emailL = new JLabel("Email ID");
        emailL.setBounds(20, 200, 100, 20);
        add(emailL);

        emailTF = new JTextField();
        emailTF.setBounds(130, 200, 100, 20);
        add(emailTF);


        // Gender Section
        genderL = new JLabel("Gender");
        genderL.setBounds(20, 250, 100, 20);
        add(genderL);

        maleRB = new JRadioButton("Male");
        femaleRB = new JRadioButton("Female");
        maleRB.setBounds(130, 250, 80, 20);
        femaleRB.setBounds(220, 250, 100, 20);
        add(maleRB);
        add(femaleRB);

        ButtonGroup gen = new ButtonGroup();
        gen.add(maleRB);
        gen.add(femaleRB);

        // DOB Section
        dobL = new JLabel("DOB");
        dobL.setBounds(20, 300, 100, 20);
        add(dobL);

        dayCB = new JComboBox(days);
        monthCB = new JComboBox(months);
        yearCB = new JComboBox(years);
        dayCB.setBounds(130, 300, 50, 20);
        monthCB.setBounds(190, 300, 50, 20);
        yearCB.setBounds(250, 300, 60, 20);
        add(dayCB);
        add(monthCB);
        add(yearCB);

        // Address Section
        addressL = new JLabel("Address");
        addressL.setBounds(20, 350, 100, 20);
        add(addressL);

        addressTA = new JTextArea();
        addressTA.setBounds(130, 340, 200, 50);
        add(addressTA);

        // Exam Section
        examL = new JLabel("Exam");
        examL.setBounds(20,400,100,20);
        add(examL);

        String examb[] = {"JEE","MHT-CET"};
        examCB = new JComboBox(examb);
        examCB.setBounds(130,400,100,20);
        add(examCB);

        // Marks Section
        marksL = new JLabel("Marks");
        marksL.setBounds(20,450,100,20);
        add(marksL);

        markTF = new JTextField();
        markTF.setBounds(130, 450, 100, 20);
        add(markTF);

        // Branch Section
        branchL = new JLabel("Branch");
        branchL.setBounds(20,500,100,20);
        add(branchL);

        String branchb[] = {"COMPUTER SCIENCE","INFORMATION TECHNOLOGY","EXTC","MECHANICAL"};
        branchCB = new JComboBox(branchb);
        branchCB.setBounds(130,500,200,20);
        add(branchCB);

        // Terms Section
        termsChB = new JCheckBox("I Accept Terms and Condition");
        termsChB.setBounds(250, 550, 250, 20);
        add(termsChB);

        // Submit Button
        submitB = new JButton("Submit");
        submitB.setBounds(300, 600, 80, 20);
        submitB.addActionListener(this);
        add(submitB);

        // Display Area
        dispTA = new JTextArea();
        dispTA.setBounds(350, 100, 300, 400);
        add(dispTA);

        // MSG
        msgL = new JLabel("");
        msgL.setBounds(240, 650, 250, 20);
        add(msgL);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (termsChB.isSelected()) {
            String name = nameTF.getText();
            String num = mobileTF.getText();
            String email = emailTF.getText();
            String exam = (String)(examCB.getSelectedItem());
            String marks = markTF.getText();
            String branch = (String)branchCB.getSelectedItem();
            String gender = femaleRB.isSelected() ? "Female" : "Male";
            String dob = dayCB.getSelectedItem() + "-" + monthCB.getSelectedItem() + "-" + yearCB.getSelectedItem();
            String address = addressTA.getText();
            
            String data = "Name: " + name + "\nMobile Number: " + num+"\nEmail ID: "+ email + "\nGender: " + gender + "\nDOB: " + dob
                    + "\nAddress: " + address +"\nExam: " + exam  + "\nMarks: " + marks + "\nBranch: " + branch;
            dispTA.setText(data);
            
            try {
                File file = new File(num + ".txt"); // Using mobile number as unique identifier
                if (file.createNewFile()) {
                    try {
                        FileWriter fw = new FileWriter(num + ".txt");
                        fw.write(data);
                        fw.close();
                        msgL.setText("           Registration Successful");
                    } catch (Exception err) {
                        System.out.println(err);
                    }
                }
                else {
                    System.out.println("              File already exists.");
                    msgL.setText("             User already exists!!");
                }
            } catch (Exception err) {
                System.out.println(err);
            }
        } else {
            msgL.setText("*Please Accept Terms and Condition");
        }
    }

    public static void main(String[] args) {
        new Form();
    }
}