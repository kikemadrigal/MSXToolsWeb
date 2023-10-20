import models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author casa
 */
@WebServlet(urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List <Usuario> listaUsuarios=new ArrayList<>();
        listaUsuarios.add(new Usuario("13","Juan","Martinez","699365455"));
        listaUsuarios.add(new Usuario("4545","Pedro","Rodriguez","548454"));
        listaUsuarios.add(new Usuario("25546456","kike","madrigal","699587444"));
        HttpSession miSesion=request.getSession();
        miSesion.setAttribute("listaUsuarios", listaUsuarios);
        response.sendRedirect("mostrarUsuarios.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni=request.getParameter("dni");
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String telefono=request.getParameter("telefono");
        System.out.println("DNI es "+ dni);
        System.out.println("nombre es "+ nombre);
        System.out.println("Apellidos es "+ apellido);
        System.out.println("telefono es "+ telefono);

        //processRequest(request, response);
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
