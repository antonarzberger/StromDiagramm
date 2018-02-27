
import java.util.ArrayList;

public class MyPoint {

  private int x;
  private int y;
  private int id;

    public MyPoint() {
    }
    
    public MyPoint transform2(int first, int second){
      MyPoint point = new MyPoint();
      int delta = second - first;
      point.setX(second);
      point.setY((int) (6.666 * 3600 / delta));
 
      return point;   
    }
    
    public ArrayList<MyPoint> transformToSvg2(ArrayList<MyPoint> list,
            int windowW, int windowH){
        int xVal = 0;
        ArrayList<MyPoint> newList = new ArrayList<>();
        for(MyPoint p : list){
            p.setX(calculateX2(p.getX(), windowW, list.get(list.size())));
            p.setY(calculateY(p.getY(), windowH));
            newList.add(p);
        }
        return newList ;
    }
    
    public int calculateX2(int x, int w, int delta){
        
//        return (int) 10 + x / 88;  // 88 => 48h, 44 => 24h, 22 =>22h (zettel knows!)
      return (int)   (10 + w * x / (96 * 60 *60));  // für 48h
    }    
    
    public MyPoint transform(int first, int second){
      MyPoint point = new MyPoint();
      int delta = second - first;
      point.setX(delta);
      point.setY((int) (6.666 * 3600 / delta));
 
      return point;   
    }
    
    public ArrayList<MyPoint> transformToSvg(ArrayList<MyPoint> list,
            int windowW, int windowH){
        int xVal = 0;
        ArrayList<MyPoint> newList = new ArrayList<>();
        for(MyPoint p : list){
        //  System.out.println(p.getX()+" | "+p.getY());
            xVal += p.getX();
            p.setX(calculateX(xVal, windowW));
            p.setY(calculateY(p.getY(), windowH));
            newList.add(p);
        }
        return newList ;
    }
    
        public int calculateX(int x, int w){
        
//        return (int) 10 + x / 88;  // 88 => 48h, 44 => 24h, 22 =>22h (zettel knows!)
      return (int) 3 *   (10 + w * x / (96 * 60 *60));  // für 48h
    }
        
    public int calculateY(int y, int h){
      double newy = y;
      double r2 = (10 + (h * (1 - (newy / 3000))));    
      return (int) r2;
    }
  
  public MyPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }
 
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
