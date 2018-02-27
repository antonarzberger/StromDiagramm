


import java.util.ArrayList;

public class History {
  
  public ArrayList<MyPoint> getPoints(ArrayList<Integer> list,
          int windowW, int windowH){
      
      
      ArrayList<MyPoint> pointList = getPointList(list);
      ArrayList<MyPoint> windowPoints = getWindowPoints(pointList, windowW, windowH);
      
    return windowPoints;
  }
    public ArrayList<MyPoint> getWindowPoints(ArrayList<MyPoint> list, 
          int windowW, int windowH){
      MyPoint mp = new MyPoint();
      
      return mp.transformToSvg2(list, windowW, windowH);
  }
    
    public ArrayList<MyPoint> getPointList(ArrayList<Integer> list){
      ArrayList<MyPoint> newList = new ArrayList<>();
      for(int i = 1; i< list.size(); i++){
          MyPoint p = new MyPoint();
          p = p.transform2(list.get(i - 1), list.get( i ));
          newList.add(p);
      }
      return newList;
  }
    
  public ArrayList<MyPoint> doIt(ArrayList<Integer> list,
          int windowW, int windowH){
    int start = list.get(list.size());
    int x,y;
    ArrayList<MyPoint> pointList = new ArrayList<>();
    for(int i = 1; i< list.size(); i++){
      MyPoint p = new MyPoint();
      
      
      
      
    }
    
    
    return pointList;
  }

  
}




//.............
//
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.util.ArrayList;
//
//public class History {
//  
//  public ArrayList<MyPoint> getPoints(int value, String unit,
//          int windowW, int windowH){
//      
//      int val = getStartTime( value, unit);
//      ArrayList<Integer> list = getTimeStampList(val);
//      ArrayList<MyPoint> pointList = getPointList(list);
//      ArrayList<MyPoint> windowPoints = getWindowPoints(pointList, windowW, windowH);
//      
//    return windowPoints;
//  }
//    public ArrayList<MyPoint> getWindowPoints(ArrayList<MyPoint> list, 
//          int windowW, int windowH){
//      MyPoint mp = new MyPoint();
//      
//      return mp.transformToSvg(list, windowW, windowH);
//  }
//    
//    public ArrayList<MyPoint> getPointList(ArrayList<Integer> list){
//      ArrayList<MyPoint> newList = new ArrayList<>();
//      for(int i = 1; i< list.size(); i++){
//          MyPoint p = new MyPoint();
//          p = p.transform(list.get(i - 1), list.get( i ));
//          newList.add(p);
//      }
//   //   System.out.println("getPointList: list.size "+newList.size()); // ok
//      return newList;
//  }
//    
//    public  ArrayList<MyPoint> svgDayList(ArrayList<MyPoint> list,
//           int startUnixtime, int windowW, int windowH){
//        
//        
//        
//        return null;
//    }
//  
//  public ArrayList<Integer> getTimeStampList(int startValue){
//      int endValue = 0;
//      ArrayList<Integer> list = new ArrayList<>();
//      ArrayList<String> rawData = new MyFileWorker().readTextFile();
//      System.out.println("rawData.size: "+rawData.size());  //ok
//      int timestamp = Integer.parseInt(rawData.get(rawData.size() - 1));
//      System.out.println("timestamp: "+timestamp);          //ok
//      for(int i = rawData.size() - 1; i > 0 && timestamp > startValue; i--){
//          timestamp = Integer.parseInt(rawData.get(i));
// //         System.out.println("Hier: "+timestamp);
//          list.add(timestamp);
//      }
//      System.out.println("List.size: "+ list.size());  // ok
//      list = reverse(list);
//      
//      System.out.println("Reverse List.size: "+ list.size());  // ok
//      return list;
//  }
//  
//  public ArrayList<Integer> reverse(ArrayList<Integer> list){
//       int size = list.size();
//       int temp = 0;
//       for(int i = 0; i <= (int) size / 2; i++){
//           temp = list.get(i);
//           list.set(i, list.get(size - 1 - i));
//           list.set(size - 1 - i, temp);
//       }
//       return list;
//  }
//  
//  public int getStartTime(int value, String unit){
//      int val;
//      int now = (int) System.currentTimeMillis() / 1000;
//      //int now = (int)LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
//      switch(unit){
//          case("hour"):
//              if(value > 48) val = now - 48 * 60 * 60;
//              else val = now - value * 60 * 60;
//          break;
//          default: val = -1;
//      }
//      return val;
//  }
//
//  
//}
//
