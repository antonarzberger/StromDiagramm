


import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFileWorker {
  String path = "/home/toni/meineProjekte/motion/timeline.txt";
//  ArrayList<String> textList;
  
  public MyFileWorker(){
    
  }
  public MyFileWorker(String path) {  // only for testing
    this.path = path;
//    textList = readTextFile(path); 
  }
  
      public ArrayList<ArrayList> getAll() {
        ArrayList<ArrayList> listAll = new ArrayList<>();

        int start = 1518908400;  //  18.Feb 00:00
        int end = start + 86400;
        boolean bool = true;
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("/home/toni/meineProjekte/motion/timeline.txt"))) {
            while (bool) {
                if (scanner.hasNextLine()) {
                    int val = Integer.parseInt(scanner.nextLine().trim());
                    if (val <= end) {  //  gleicher Tag
                        list.add(val);
                    } else {           //  neuer Tag
                        end += 86400;
                        list.add(start);  
                        start+=86400;
                        
                        listAll.add(list);
                        list = new ArrayList<>();
                        list.add(val);
                    }
                }
                else{       // only once => end of while
                   bool = false; 
                   list.add(start);
                   listAll.add(list);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: "+ ex);
        }
        return listAll;
    }
  
  public ArrayList<String> readTextFile(){
    ArrayList<String> stringList = new ArrayList<>();
    try (Scanner scanner = new Scanner(Paths.get(path))){
      while (scanner.hasNextLine()){
        stringList.add(scanner.nextLine().trim());
      }
    } catch (IOException ex) {
      Logger.getLogger(MyFileWorker.class.getName()).log(Level.SEVERE, null, ex);
    }
 //     System.out.println("stringList.size: "+stringList.size());
    return stringList;
  }
}