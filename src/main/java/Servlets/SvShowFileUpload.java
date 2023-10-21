package Servlets;

import database.SQLiteClient;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.FileUpload;
import utils.Constants;
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
        ArrayList<String> arrayListText=null;
        try{
            id=Integer.parseInt(idString);
            fileUpload=sqliteClient.getFileDataBase(id);
            File file=new File(fileUpload.getPath());
            arrayListText=fileManager.readFile(file);
            //fileManager.createZip(file, arrayListText);   
         }catch(NumberFormatException ex){
             System.out.println("Servlets.SvDeleteFileUpload.doPost()");
         } 

        HttpSession miSesion=request.getSession();
        miSesion.setAttribute("fileUpload", fileUpload);
        miSesion.setAttribute("arrayListText", arrayListText);
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
