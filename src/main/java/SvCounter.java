import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/SvCounter"})
public class SvCounter extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int lenghtWord=0;
            int lenghtLines=0;
            String text="";
            String textSinSaltosDeLinea="";
            String cutString="";
            
            int cut=0;
            if(request.getParameter("text")!=null){
                text=request.getParameter("text").trim();
                cutString=request.getParameter("cut");
                try{
                   cut=Integer.parseInt(cutString);
                }catch(NumberFormatException ex){
                   cut=0;
                } 
            }
  
            //System.out.println("El calor de cut es"+String.valueOf(cut));
            //System.out.println("El calor de text es"+text);
                
           
            //Obtenemos un array con las lineas
            String[] lines=text.split("\n");
            lenghtLines=lines.length;
            

            if(cut!=0){
                int progress=0;
                text="";
                lenghtLines=0;
                //Por cada linea
                for (String line: lines) {
                    if(progress<cut){
                        text+=line+"\n";
                        lenghtLines++;
                    }
                    progress++;   
                }

            }
    
            textSinSaltosDeLinea=text.replaceAll("(\n|\r)", "");
            lenghtWord=textSinSaltosDeLinea.length();
            HttpSession miSesion=request.getSession();
            miSesion.setAttribute("lenghtWord",lenghtWord);
            miSesion.setAttribute("lenghtLines",lenghtLines);
            miSesion.setAttribute("text",text);
            response.sendRedirect("counter.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int lenght=0;
            String text=request.getParameter("text");
            String cutString=request.getParameter("cut");
            //lenght=text.length();
            HttpSession miSesion=request.getSession();
            miSesion.setAttribute("lenght",lenght);
            miSesion.setAttribute("text",text);
            response.sendRedirect("counter.jsp");
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
