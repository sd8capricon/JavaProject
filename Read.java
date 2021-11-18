// Example to filter data wrt to name

import java.io.File;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        
        File dirpath = new File(".");
        File filesList[] = dirpath.listFiles((d, name) -> name.endsWith(".txt")); 
        // ^ java Lambda func. Similar to JS ES6 anonymous arrow funcs

        String searchTerm = "Siddharth";
        
        for(File fileName: filesList){
            String fName = fileName.getName();
            try {
                File file = new File(fName);
                Scanner sc = new Scanner(file);
                // int counter = 0;
                String data = "";
                // System.out.println(file.exists());
                while(sc.hasNextLine()){
                    data = data.concat("\n"+sc.nextLine());
                }
                if(data.contains(searchTerm)){
                    System.out.println(true);
                }
                sc.close();
            } catch (Exception err) {
                System.out.println("File Not Found");
            }
        }
    }
}
