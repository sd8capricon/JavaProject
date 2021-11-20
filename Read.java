// Example to filter data wrt name of user

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {

        File dirPath = new File(".");
        File filesList[] = dirPath.listFiles((d, name) -> name.endsWith(".txt"));
        // ^ java Lambda func. Similar to JS ES6 anonymous arrow funcs

        Scanner sc = new Scanner(System.in);
        String searchTerm = "Siddharth";
        sc.close();

        ArrayList<String> dataList = new ArrayList<String>();

        for (File fileName : filesList) {
            try {
                Scanner fsc = new Scanner(fileName);
                String data = "";
                while (fsc.hasNextLine()) {
                    data = data.concat("\n" + fsc.nextLine());
                }
                if (data.contains(searchTerm)) {
                    dataList.add(data);
                }
                fsc.close();
            } catch (Exception err) {
                System.out.println(err);
            }
        }
        if (dataList.isEmpty()) {
            System.out.println("No User Found with Specified name");
        } else {
            System.out.println(dataList);
        }
    }
}
