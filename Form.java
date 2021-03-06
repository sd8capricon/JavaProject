import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.awt.Color;

public class Form extends JFrame implements ActionListener {
    JLabel nameL, mobileL, genderL, dobL, addressL, greenmsgL, redmsgL, emailL,examL,marksL,branchL,collegeL,searchL;
    JTextField nameTF, mobileTF, emailTF,markTF;
    JTextArea addressTA, dispTA;
    JRadioButton maleRB, femaleRB;
    JComboBox dayCB, monthCB, yearCB,examCB,branchCB;
    JCheckBox termsChB;
    JButton submitB, searchB, exitB, resetB;
    

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
        markTF.setText("");
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
        dispTA.setBounds(350, 80, 300, 420);
        add(dispTA);

        // Green MSG
        greenmsgL = new JLabel("");
        greenmsgL.setForeground(new Color(0, 128, 0));
        greenmsgL.setBounds(240, 630, 250, 20);
        add(greenmsgL);

        // Red MSG
        redmsgL = new JLabel("");
        redmsgL.setForeground(Color.RED);
        redmsgL.setBounds(240, 630, 250, 20);
        add(redmsgL);

        // Search button
        searchL = new JLabel("To Search Application");
        searchL.setBounds(20, 670, 150, 20);
        add(searchL);

        searchB = new JButton("Search");
        searchB.setBounds(170, 670, 80, 20);
        add(searchB);
        searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPage sPage = new SearchPage();
				sPage.setVisible(true);
                setVisible(false);
			}
		});

        resetB = new JButton("Reset");
        resetB.setBounds(510, 670, 70, 20);
        add(resetB);
        resetB.addActionListener(this);

        exitB = new JButton("Exit");
        exitB.setBounds(590, 670, 60, 20);
        add(exitB);
        exitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        setVisible(true);
    }
    void clearTF(){
        nameTF.setText("");
        mobileTF.setText("");
        emailTF.setText("");
        addressTA.setText("");
        markTF.setText("");
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitB){
            if (termsChB.isSelected()) {
                String name = nameTF.getText();
                String num = mobileTF.getText();
                String email = emailTF.getText();
                String exam = (String)(examCB.getSelectedItem());
                String marks = markTF.getText();
                String branch = (String)branchCB.getSelectedItem();
                String dob = dayCB.getSelectedItem() + "-" + monthCB.getSelectedItem() + "-" + yearCB.getSelectedItem();
                String address = addressTA.getText();
                int checkat = email.indexOf('@');
                //checking whether any textfield or checkbox is empty
                if( !(name.isEmpty()) && !(num.isEmpty()) && !(email.isEmpty()) && !(marks.isEmpty()) && !(address.isEmpty()) && (femaleRB.isSelected() || maleRB.isSelected())){
                    // checking for @ in mail id and int in num and marks texfieds and whether name contains special char or number
                    boolean alphaCheck = name.matches("[a-zA-Z]+");
                    if(checkat>-1 && num.matches("[0-9]+") && marks.matches("[0-9]+") && (alphaCheck)){  
                        String gender = femaleRB.isSelected() ? "Female" : "Male";
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
                                    redmsgL.setText("");
                                    greenmsgL.setText("           Registration Successful");
                                    clearTF();
                                } catch (Exception err) {
                                System.out.println(err);
                                }
                            }
                            else {
                                System.out.println("              File already exists.");
                                greenmsgL.setText("");
                                redmsgL.setText("             User already exists!!");
                            }
                        } catch (Exception err) {
                            System.out.println(err);
                        }
                    } else {
                        if (!(alphaCheck)){
                            greenmsgL.setText("");
                            redmsgL.setText("               *Enter Correct Name");
                        } else if (!(num.matches("[0-9]+"))){
                            greenmsgL.setText("");
                            redmsgL.setText("             *Enter Correct Number");
                        } else if(!(checkat>-1)){
                            greenmsgL.setText("");
                            redmsgL.setText("           *Enter Correct Email ID");
                        } else if (!(marks.matches("[0-9]+"))){
                            greenmsgL.setText("");
                            redmsgL.setText("              *Enter Correct Marks");
                        }
                    }
                } else {
                    if(name.isEmpty()){
                        greenmsgL.setText("");
                        redmsgL.setText("                       *Enter Name");
                    } else if(num.isEmpty()){
                        greenmsgL.setText("");
                        redmsgL.setText("                     *Enter Number");
                    } else if(email.isEmpty()){
                        greenmsgL.setText("");
                        redmsgL.setText("                   *Enter Email ID");
                    } else if (!(femaleRB.isSelected() || maleRB.isSelected())){
                        greenmsgL.setText("");
                        redmsgL.setText("                    *Select Gender");
                    } else if(address.isEmpty()){
                        greenmsgL.setText("");
                        redmsgL.setText("                    *Enter Address");
                    } else if(marks.isEmpty()){
                        greenmsgL.setText("");
                        redmsgL.setText("                      *Enter Marks");
                    }
                }
            } else { 
                greenmsgL.setText("");
                redmsgL.setText("*Please Accept Terms and Condition");
            }
        }
        if(e.getSource() == resetB){
            clearTF();
            dispTA.setText("");
        }
    }
    public static void main(String[] args) {
        new Form();
    }
}