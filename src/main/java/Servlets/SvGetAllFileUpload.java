package Servlets;

import database.SQLiteClient;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.FileUpload;


@WebServlet(name = "SvGetAllFile", urlPatterns = {"/SvGetAllFile"})
public class SvGetAllFileUpload extends HttpServlet {
    private SQLiteClient sqliteClient=new SQLiteClient(); 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<FileUpload> listFiles=sqliteClient.getAllFilesDataBase();
        System.out.println("size: "+listFiles.size());
        HttpSession miSesion=request.getSession();
        miSesion.setAttribute("listFiles", listFiles);
        response.sendRedirect("delete-comments.jsp");
    }

    @Override
    public void destroy() {
        sqliteClient.disconnect();
        super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

  

}
