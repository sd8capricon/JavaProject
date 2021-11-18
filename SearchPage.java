import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class SearchPage extends JFrame implements ActionListener{

    JTextField numTF, nameTF;
    JButton searchBtn;

    SearchPage(){
        setTitle("Student Registration Form");
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    };

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchBtn){
            String num = numTF.getText();
            // String name = nameTF.getText();
            
            int counter = 0;
            try {
                File file = new File(num + ".txt");
                Scanner sc = new Scanner(file);
                while(counter == 0){
                    String data = sc.nextLine();
                    if (counter == 0){
                        data = data.substring(6);
                        System.out.println(data);
                    }
                    // System.out.println(data);
                    counter++;
                }
                sc.close();
            } catch (Exception err) { 
                System.out.println("File Not Found");
            }
        }
    }

    public static void main(String[] args) {
        new SearchPage();
    }
}
