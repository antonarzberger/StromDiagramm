
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet NewServlet</title>");
      out.println("</head>");
      out.println("<body>");
      MyFileWorker w = new MyFileWorker();
      ArrayList<ArrayList> list = w.getAll();
      LineHoriz lineHoriz = new LineHoriz();
      int height = 400;
      int width = 2000;
      for (ArrayList alist : list) {
        Integer timestampI =  (int) alist.get(alist.size() -1 ) ;
        long timestamp = timestampI.longValue();
        LocalDateTime date =  LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp),
                              TimeZone.getDefault().toZoneId()); 
        
        out.println("<h1>" + date.getDayOfMonth()+"."+date.getMonthValue() + 
                ",    # "+ alist.size()+"</h1>");
        out.println("<svg  height=\""+height+"\" width=\""+width+"\">");

        out.println("<rect height=\""+height+"\" width=\""+width+"\" "
                + "style=\"fill:rgb(179, 198, 255);"
                + "stroke-width:3;stroke:rgb(0,0,0)\" />");
        
        int start = (int) (width * 1.0 * 3 / 4);
        for (int i = 0; i < 6; i++) {
          out.println("<line x1=\"" + start
                  + "\" y1=\"" + 0
                  + "\" x2=\"" + start
                  + "\" y2=\"" + height
                  + "\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
          start += (int)(width * 1.0 / 24);
        }
        out.println("<rect width=\""+(int) (width * 1.0 * 3 / 4)+"\" height=\""+height+"\" "
                + "style=\"fill:rgb(255, 255, 153);"
                + "stroke-width:3;stroke:rgb(0,0,0)\" />");
        start = (int) (width * 1.0 / 4);
        for (int i = 0; i < 12; i++) {
          out.println("<line x1=\"" + start
                  + "\" y1=\"" + 0
                  + "\" x2=\"" + start
                  + "\" y2=\"" + height
                  + "\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
          start += (int)(width * 1.0 / 24);
        }
        out.println("<rect width=\""+ (int) (width * 1.0 / 4) +"\" height=\""+height+"\" "
                + "style=\"fill:rgb(179, 198, 255);"
                + "stroke-width:3;stroke:rgb(0,0,0)\" />");
        start =  0;
        for (int i = 0; i < 6; i++) {
          out.println("<line x1=\"" + start
                  + "\" y1=\"" + 0
                  + "\" x2=\"" + start
                  + "\" y2=\"" + height
                  + "\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
          start += (int)(width * 1.0 / 24);
        }
        
       
        ArrayList<LineHoriz> lineList = lineHoriz.lineList(alist, 2000, 400);

        for (int i = 0; i < lineList.size() - 1; i++) {
          out.println("<line x1=\"" + lineList.get(i).getX1() + "\" y1=\""
                  + lineList.get(i).getY()
                  + "\" x2=\"" + lineList.get(i).getX2() + "\" y2=\""
                  + lineList.get(i).getY()
                  + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
          out.println("<line x1=\"" + lineList.get(i).getX2() + "\" y1=\""
                  + lineList.get(i).getY()
                  + "\" x2=\"" + lineList.get(i + 1).getX1() + "\" y2=\""
                  + lineList.get(i + 1).getY()
                  + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");

        }
        
        out.println("<line x1=\"" + (int) (width * 1.0 / 2)
                + "\" y1=\"" + 0
                + "\" x2=\"" + (int) (width * 1.0 / 2)
                + "\" y2=\"" + height
                + "\" style=\"stroke:rgb(0,0,0);stroke-width:2\" />");


        out.println("</svg>");
      }

//.....        
//        ArrayList<MyPoint> pointList = history.getPoints(alist, 2000, 400);
//
//        int x0 = 10;
//        int y0 = 410;
//
//        for (MyPoint p : pointList) {
//          out.println("<circle cx=\"" + p.getX() + "\" cy=\"" + p.getY()
//                  + "\" r=\"1\" stroke=\"red\" stroke-width=\"0\" fill=\"red\" ></circle>");
//
//          if (p.getY() >= y0) {
//            out.println("<line x1=\"" + x0 + "\" y1=\"" + y0
//                    + "\" x2=\"" + x0 + "\" y2=\"" + p.getY()
//                    + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//            out.println("<line x1=\"" + x0 + "\" y1=\"" + p.getY()
//                    + "\" x2=\"" + p.getX() + "\" y2=\"" + p.getY()
//                    + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//          } else {
//            out.println("<line x1=\"" + x0 + "\" y1=\"" + y0
//                    + "\" x2=\"" + x0 + "\" y2=\"" + p.getY()
//                    + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//            out.println("<line x1=\"" + x0 + "\" y1=\"" + p.getY()
//                    + "\" x2=\"" + p.getX() + "\" y2=\"" + p.getY()
//                    + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//
//          }
//
//        out.println("<line x1=\"" + x0 + "\" y1=\"" + y0
//                + "\" x2=\"" + p.getX() + "\" y2=\"" + p.getY()
//                + "\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
//          x0 = p.getX();
//          y0 = p.getY();
//        }
//
//         
//        out.println("</svg>");
//      }
//.....   
//            LocalDateTime now = LocalDateTime.now();
//            out.println("<h3>" + now + "</h3>");
//            int year = now.getYear();
//            int month = now.getMonthValue();
//            int day = now.getDayOfMonth();
//            int hour = now.getHour();
//            if (hour < 13) {
//                hour = 0;
//            } else {
//                hour = 12;
//            }
//
//            LocalDateTime ldt = LocalDateTime.of(year, month, day, 23, 00, 00);
//            int midnightNoonSeconds = (int) ((ldt.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli()) / 1000);
////      
//
//            out.println("<svg id=\"area\" height = \"410\" width = \"10020\">");
//            out.println("<rect width=\"10020\" height=\"410\" style=\"fill:rgb(255, 255, 153);stroke-width:3;stroke:rgb(0,0,0)\" />");
//
//            History history = new History();
//            ArrayList<MyPoint> list = history.getPoints(96, "hour", 7000, 400);
//
//            int x0 = 10;
//            int y0 = 410;
//
//            for (MyPoint p : list) {
//                out.println("<circle cx=\"" + p.getX() + "\" cy=\"" + p.getY()
//                        + "\" r=\"1\" stroke=\"red\" stroke-width=\"0\" fill=\"red\" ></circle>");
//
//                if (p.getY() >= y0) {
//                    out.println("<line x1=\"" + x0 + "\" y1=\"" + y0
//                            + "\" x2=\"" + x0 + "\" y2=\"" + p.getY()
//                            + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//                    out.println("<line x1=\"" + x0 + "\" y1=\"" + p.getY()
//                            + "\" x2=\"" + p.getX() + "\" y2=\"" + p.getY()
//                            + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//                } else {
//                    out.println("<line x1=\"" + x0 + "\" y1=\"" + y0
//                            + "\" x2=\"" + x0 + "\" y2=\"" + p.getY()
//                            + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//                    out.println("<line x1=\"" + x0 + "\" y1=\"" + p.getY()
//                            + "\" x2=\"" + p.getX() + "\" y2=\"" + p.getY()
//                            + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
//
//                }
//
////        out.println("<line x1=\"" + x0 + "\" y1=\"" + y0
////                + "\" x2=\"" + p.getX() + "\" y2=\"" + p.getY()
////                + "\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
//                x0 = p.getX();
//                y0 = p.getY();
//            }
//            out.println("<h1>" + midnightNoonSeconds + "</h1>");
//            out.println("</svg>");
      out.println("</body>");
      out.println("</html>");
    }

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
