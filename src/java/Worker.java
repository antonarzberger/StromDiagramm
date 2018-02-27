

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker {

    public ArrayList<ArrayList> getAll() {
        ArrayList<ArrayList> listAll = new ArrayList<>();

        int start = 1518908400;
        int end = start + 86400;
        boolean bool = true;
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("C:\\Users\\dotne\\OneDrive\\Documents\\timeline.txt"))) {
            while (bool) {
                if (scanner.hasNextLine()) {
                    int val = Integer.parseInt(scanner.nextLine().trim());
                    if (val <= end) {
                        list.add(val);
                    } else {
                        end += 86400;
                        listAll.add(list);
                        list = new ArrayList<>();
                        list.add(val);
                    }
                }
                else{
                   bool = false; 
                   listAll.add(list);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAll;
    }
    public int getMidnightOfDayFromSecond(int sec) {
        Calendar mydate = Calendar.getInstance();
        mydate.setTimeInMillis(sec * 1000);
        int year = mydate.get(Calendar.YEAR);
        int month = (mydate.get(Calendar.MONTH));
        int day = mydate.get(Calendar.DAY_OF_MONTH);

        mydate.set(year, month, day, 0, 0, 0);
        return (int) (mydate.getTimeInMillis() / 1000);

//      LocalDateTime ldt = LocalDateTime.of(year, month+1, day, 00, 00, 00);
//      return (int) ((ldt.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli()) / 1000);
    }
}
