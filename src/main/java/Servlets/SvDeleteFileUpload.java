
package Servlets;

import database.SQLiteClient;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvDeleteFileUpload", urlPatterns = {"/SvDeleteFileUpload"})
public class SvDeleteFileUpload extends HttpServlet {
    SQLiteClient sqliteClient=new SQLiteClient();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            int id=0;
            String idString=request.getParameter("id").trim();
            System.out.println("Borrando el "+idString);
            try{
               id=Integer.parseInt(idString);
               sqliteClient.deleteFile(id);
               sqliteClient.disconnect();
            }catch(NumberFormatException ex){
                System.out.println("Servlets.SvDeleteFileUpload.doPost()");
            } 
         }
         response.sendRedirect("delete-comments.jsp");
    }



}
