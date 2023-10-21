package Servlets;

import controllers.FileController;
import database.SQLiteClient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.Constants;


import utils.DeleteComments;
import utils.FileManager;
import utils.StringManager;

/**
 *
 * @author casa
 */
//Cn multipartconfig hacemos que podamos recibir archivos
@MultipartConfig
@WebServlet(name = "SvInsertFileUpload", urlPatterns = {"/SvInsertFileUpload"})
public class SvInsertFileUpload extends HttpServlet {
    private FileController fileController=new FileController();
    private File filesUploads=new File(Constants.getPathFiles());
    private String[] extensiones={".bas", ".BAS"};
    
    private FileManager fileManager=new FileManager();
    private StringManager stringManager=new StringManager();
    private DeleteComments deleteComments=new DeleteComments(fileManager,stringManager);
    
    private SQLiteClient sqliteClient=new SQLiteClient(); 
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action=req.getParameter("submit");
        switch (action) {
            case "Convert":
                System.out.println("vamnos a convertir el archivo");
                saveFileUpload(req, resp);
                resp.sendRedirect("delete-comments.jsp");
                break;
            default:
                break;
        }
    }
    
    private void saveFileUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try {
            String comment1=req.getParameter("comment1");
            String comment2=req.getParameter("comment2");
            String comment3=req.getParameter("comment3");
            String excepted1=req.getParameter("excepted1");
            String excepted2=req.getParameter("excepted2");
            String excepted3=req.getParameter("excepted3");
            String[] comments={comment1, comment2, comment3};
            String[] excepted={excepted1, excepted2, excepted3};
            Part part =req.getPart("file");
            
            if(part==null){
                System.out.println("No ha seleccionado un archivo");
                return;
            }
                           System.out.println("estamos dentro de saveFileUpload");
            if(isExtension(part.getSubmittedFileName(), extensiones)){
                String fileAbsolutePath=saveFile(part, filesUploads);
                Path path=Paths.get(part.getSubmittedFileName());
                String fileNameOriginFile=path.getFileName().toString();
                File fileDestiny=new File(Constants.getPathFiles()+fileNameOriginFile);
                File file=new File(fileAbsolutePath);
                file.createNewFile();
                if(fileManager.checkFile(file)){
                    //Creamos el archivo sin comentarios
                   deleteComments.converterWithFileDestiny(file,fileDestiny,comments,excepted); 
                   //Creamos el zip
                   ArrayList<String> arrayListText=fileManager.readFile(fileDestiny);
                   fileManager.createZip(fileDestiny, arrayListText);   
                   //Lo metemos en la base de datos
                   sqliteClient.insertFileDataBase(fileDestiny);                   
                }
                else
                    System.out.println("Archivo "+fileDestiny.toString()+" inaccesible");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        

    }
    
    
    //La clase part nos permite manejar los archivos subidos y la tenemos que importar de javax.servlet.http.Part;
    private String saveFile(Part part, File pathUploads){
        String pathAbsolute="";
        try {
            //java.nio.file.Path y java.nio.file.Paths;
            Path path=Paths.get(part.getSubmittedFileName());
            //String fileName=path.getFileName().toString();
            String fileName="temp.bas";
            InputStream input=part.getInputStream();
            
            if(input!=null){
                File file=new File(pathUploads, fileName);
                pathAbsolute=file.getAbsolutePath();
                if(!file.exists()) {
                    file.createNewFile();
                }
                //Aquí guardamos nuestro archivo en el servidor
                Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(Exception ex){
            
        }
        return pathAbsolute;
    }
    
    private boolean isExtension(String fileName, String[] extensions){
        for(String et:extensions){
            if(fileName.toLowerCase().endsWith(et)){
                return true;
            }
        }
        return false;
    }

    
    
    
    @Override
    public void destroy() {
        sqliteClient.disconnect();
        super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    


}
