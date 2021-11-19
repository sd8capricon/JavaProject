import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchPage extends JFrame implements ActionListener{
    JLabel nameL;
    JTextField numTF, nameTF;
    JButton searchBtn;

    SearchPage(){
        setTitle("Search Name");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Name
        nameL = new JLabel("Enter Name");
        nameL.setBounds(20,50,100,20);
        add(nameL);

        nameTF = new JTextField();
        nameTF.setBounds(110,50,100,20);
        add(nameTF);

        // Search button
        searchBtn = new JButton("Search");
        searchBtn.setBounds(120,90,80,20);
        add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if(e.getSource() == searchBtn){
                    // String num = numTF.getText();
                    String name = nameTF.getText();
                    
                    File dirPath = new File(".");
                    File filesList[] = dirPath.listFiles((d, fname) -> fname.endsWith(".txt")); 
                    // ^ java Lambda func. Similar to JS ES6 anonymous arrow funcs
        
                    String searchTerm = name;
        
                    ArrayList<String> dataList = new ArrayList<String>();
                    
                    for(File fileName: filesList){
                        // String fName = fileName.getName();
                        try {
                            // File file = new File(fName);
                            Scanner fsc = new Scanner(fileName);
                            // int counter = 0;
                            String data = "";
                            // System.out.println(file.exists());
                            while(fsc.hasNextLine()){
                                data = data.concat("\n"+fsc.nextLine());
                            }
                            if(data.contains(searchTerm)){
                                // System.out.println(data);
                                dataList.add(data);
                            }
                            fsc.close();
                        } catch (Exception err) {
                            System.out.println(err);
                        }
                    }
        
                    // TODO:Handle these in GUI as well
                    if (dataList.isEmpty()) {
                    } else {
                    }
                }
			}
		});
    };

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {
        new SearchPage();
    }
}