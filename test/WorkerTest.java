

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class WorkerTest {
    
    public WorkerTest() {
    }



    @Test
    public void testGetMidnightOfDayFromSecond() {
        System.out.println("getMidnightOfDayFromSecond");
        int sec = 0;
        Worker instance = new Worker();
        int expResult = 1519340400;//1519340400
        int result = instance.getMidnightOfDayFromSecond(1519340550);
        assertEquals(expResult, result);
    }
    
}
