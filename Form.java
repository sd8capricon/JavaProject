import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class Form extends JFrame implements ActionListener {
    JLabel nameL, mobileL, genderL, dobL, addressL, msgL,emailL,examL,marksL,branchL,collegeL,searchL;
    JTextField nameTF, mobileTF, emailTF,markTF;
    JTextArea addressTA, dispTA;
    JRadioButton maleRB, femaleRB;
    JComboBox dayCB, monthCB, yearCB,examCB,branchCB;
    JCheckBox termsChB;
    JButton submitB, searchB;
    

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
        setSize(700, 750);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //College Name
        collegeL = new JLabel("DON BOSCO INSTITUTE OF TECHNOLOGY");
        collegeL.setBounds(220,30,300,30);
        add(collegeL);

        // Name Section
        nameL = new JLabel("Name");
        nameL.setBounds(20, 80, 100, 20);
        add(nameL);

        nameTF = new JTextField();
        nameTF.setBounds(130, 80, 100, 20);
        add(nameTF);

        // Contact Section
        mobileL = new JLabel("Mobile");
        mobileL.setBounds(20, 130, 100, 20);
        add(mobileL);

        mobileTF = new JTextField();
        mobileTF.setBounds(130, 130, 100, 20);
        add(mobileTF);

        // Email Section
        emailL = new JLabel("Email ID");
        emailL.setBounds(20, 180, 100, 20);
        add(emailL);

        emailTF = new JTextField();
        emailTF.setBounds(130, 180, 100, 20);
        add(emailTF);


        // Gender Section
        genderL = new JLabel("Gender");
        genderL.setBounds(20, 230, 100, 20);
        add(genderL);

        maleRB = new JRadioButton("Male");
        femaleRB = new JRadioButton("Female");
        maleRB.setBounds(130, 230, 80, 20);
        femaleRB.setBounds(220, 230, 100, 20);
        add(maleRB);
        add(femaleRB);

        ButtonGroup gen = new ButtonGroup();
        gen.add(maleRB);
        gen.add(femaleRB);

        // DOB Section
        dobL = new JLabel("DOB");
        dobL.setBounds(20, 280, 100, 20);
        add(dobL);

        dayCB = new JComboBox(days);
        monthCB = new JComboBox(months);
        yearCB = new JComboBox(years);
        dayCB.setBounds(130, 280, 50, 20);
        monthCB.setBounds(190, 280, 50, 20);
        yearCB.setBounds(250, 280, 60, 20);
        add(dayCB);
        add(monthCB);
        add(yearCB);

        // Address Section
        addressL = new JLabel("Address");
        addressL.setBounds(20, 330, 100, 20);
        add(addressL);

        addressTA = new JTextArea();
        addressTA.setBounds(130, 320, 200, 50);
        add(addressTA);

        // Exam Section
        examL = new JLabel("Exam");
        examL.setBounds(20,380,100,20);
        add(examL);

        String examb[] = {"JEE","MHT-CET"};
        examCB = new JComboBox(examb);
        examCB.setBounds(130,380,100,20);
        add(examCB);

        // Marks Section
        marksL = new JLabel("Marks");
        marksL.setBounds(20,430,100,20);
        add(marksL);

        markTF = new JTextField();
        markTF.setBounds(130, 430, 100, 20);
        add(markTF);

        // Branch Section
        branchL = new JLabel("Branch");
        branchL.setBounds(20,480,100,20);
        add(branchL);

        String branchb[] = {"COMPUTER SCIENCE","INFORMATION TECHNOLOGY","EXTC","MECHANICAL"};
        branchCB = new JComboBox(branchb);
        branchCB.setBounds(130,480,200,20);
        add(branchCB);

        // Terms Section
        termsChB = new JCheckBox("I Accept Terms and Condition");
        termsChB.setBounds(250, 530, 250, 20);
        add(termsChB);

        // Submit Button
        submitB = new JButton("Submit");
        submitB.setBounds(300, 580, 80, 20);
        submitB.addActionListener(this);
        add(submitB);

        // Display Area
        dispTA = new JTextArea();
        dispTA.setBounds(350, 80, 300, 400);
        add(dispTA);

        // MSG
        msgL = new JLabel("");
        msgL.setBounds(240, 630, 250, 20);
        add(msgL);

        // Search button
        searchL = new JLabel("To Search Applicaation");
        searchL.setBounds(20, 670, 150, 20);
        add(searchL);

        searchB = new JButton("Search");
        searchB.setBounds(170, 670, 80, 20);
        add(searchB);
        searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPage sp = new SearchPage();
				sp.setVisible(true);
			}
		});
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