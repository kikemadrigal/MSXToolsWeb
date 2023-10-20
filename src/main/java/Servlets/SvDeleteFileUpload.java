
package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            int id=0;
            String idString=request.getParameter("id").trim();
            System.out.println("Borrando el "+idString);
            try{
               id=Integer.parseInt(idString);
               deleteFile(id);
            }catch(NumberFormatException ex){
                System.out.println("Servlets.SvDeleteFileUpload.doPost()");
            } 
         }
         response.sendRedirect("delete-comments.jsp");
    }
    private void deleteFile(int id) {
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvDeleteFileUpload.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try
        {
          File fileDB=new File("MSXTools.db");
          String url="jdbc:sqlite:"+fileDB.getAbsolutePath();
          // create a database connection
          Connection connection = DriverManager.getConnection(url);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          ResultSet rs = statement.executeQuery("select * from file where id="+id);
          while(rs.next())
          {
            String path= rs.getString("path");
            File file = new File(path);
            file.delete();
          }
              
          
          int deletedRows = statement.executeUpdate("DELETE FROM file WHERE id LIKE '"+id+"'");
          System.out.println("filas borradas: "+deletedRows);
          connection.close();
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }


    }
    


}
