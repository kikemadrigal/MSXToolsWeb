package Servlets;

import database.SQLiteClient;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.FileUpload;
import utils.FileManager;


@WebServlet(name = "SvShowFileUpload", urlPatterns = {"/SvShowFileUpload"})
public class SvShowFileUpload extends HttpServlet {
    private SQLiteClient sqliteClient=new SQLiteClient(); 
    private FileManager fileManager=new FileManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString=request.getParameter("id");
        int id=0;
        FileUpload fileUpload=null;
        ArrayList<String> arrayList=null;
        try{
            id=Integer.parseInt(idString);
            fileUpload=sqliteClient.getFileDataBase(id);
            File file=new File(fileUpload.getPath());
            arrayList=fileManager.readFile(file);
         }catch(NumberFormatException ex){
             System.out.println("Servlets.SvDeleteFileUpload.doPost()");
         } 
            
        HttpSession miSesion=request.getSession();
        miSesion.setAttribute("url", fileUpload.getPath());
        miSesion.setAttribute("arrayList", arrayList);
        response.sendRedirect("delete-comments2.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public void destroy() {
        sqliteClient.disconnect();
        super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


}
