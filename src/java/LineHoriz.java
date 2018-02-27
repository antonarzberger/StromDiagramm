
import java.util.ArrayList;

public class LineHoriz {
  
  private int x1, x2, y;

  public int getX1() {
    return x1;
  }

  public void setX1(int x1) {
    this.x1 = x1;
  }

  public int getX2() {
    return x2;
  }

  public void setX2(int x2) {
    this.x2 = x2;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
  
  public ArrayList<LineHoriz> lineList(ArrayList<Integer> list, int w, int h){
    ArrayList<LineHoriz> lineList = new ArrayList<>();
    int startVal = list.get(list.size() - 1);
    for(int i = 1; i<list.size() - 1 ; i++){
      
      LineHoriz line = new LineHoriz();
      
      int xDiff = list.get(i) - list.get(i-1);
      int y = (int) (6.666 * 3600 * 1.0 / xDiff);
      line.setY(h - (int) (( h *  (y * 1.0 / 3000))));
      int x1 = list.get(i - 1) - startVal;
      int x2 = list.get(i) - startVal;
      double x1Val = w * x1 * 1.0 / 86400;
      double x2Val = w * x2 * 1.0 / 86400;
      line.setX1((int) x1Val);
      line.setX2((int) x2Val);
      
      lineList.add(line);
    }
    return lineList;
  }

}
