
package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.FileUpload;
import utils.Constants;


public class SQLiteClient {
    private static SQLiteClient instance;
    Connection connection=null;
    private Statement statement;
     
    public SQLiteClient(){
        File fileDB=new File("MSXTools.db");
        //String url="jdbc:sqlite:"+fileDB.getAbsolutePath();
        String url="jdbc:sqlite:"+Constants.pathDB+"MSXTools.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection=DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            //statement.executeUpdate("drop table if exists file");
            //create table file (id integer primary key autoincrement, name varchar (100), path text);
            //statement.executeUpdate("create table file (id integer primary key autoincrement, name varchar(100), path text)");
            File pathFiles = new File(Constants.pathFiles);
            if (!pathFiles.exists()) {
                pathFiles.mkdir();
            } else {
                pathFiles.delete();
                if (!pathFiles.exists()) {
                    pathFiles.mkdir();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLiteClient.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    /*public static SQLiteClient getInstance(){
        if(instance==null){
            instance =new SQLiteClient();
        }
        return instance;
    }*/
    

    
    public void disconnect(){
        try {

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void deleteAll(){
        File pathFiles = new File(Constants.pathFiles);
        if (!pathFiles.exists()) {
            pathFiles.mkdir();
        } else {
            pathFiles.delete();
            if (!pathFiles.exists()) {
                pathFiles.mkdir();
            }
        }
        try {
            statement.executeUpdate("delete from file");
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertFileDataBase(File file){
        try {
          statement.executeUpdate("insert into file values(NULL,'"+file.getName()+"','"+file.getAbsolutePath()+"')");
        }
        catch(SQLException e){
          System.err.println(e.getMessage());
        }
    }
    
    
    
    public ArrayList<FileUpload> getAllFilesDataBase(){
        ArrayList<FileUpload> fileList=new ArrayList<>();       
        try {
          ResultSet rs = statement.executeQuery("select * from file");
          while(rs.next())
          {
            System.out.println("id = " + rs.getInt("id"));
            System.out.println("name = " + rs.getString("name"));
            System.out.println("path = " + rs.getString("path"));
            fileList.add(new FileUpload(rs.getInt("id"),rs.getString("name"),rs.getString("path") ));
          }
        }catch(SQLException e){
         System.err.println(e.getMessage());
         fileList.add(new FileUpload(0,"","List empty"));
        }
        return fileList;
    }
    
    public FileUpload getFileDataBase(int id){
        FileUpload fileUpload=null;    
        try {
          ResultSet rs = statement.executeQuery("select * from file where id='"+id+"'");
          while(rs.next())
          {
            System.out.println("id = " + rs.getInt("id"));
            System.out.println("name = " + rs.getString("name"));
            System.out.println("path = " + rs.getString("path"));
            fileUpload=new FileUpload(rs.getInt("id"),rs.getString("name"),rs.getString("path") );
          }
        }catch(SQLException e){
         System.err.println(e.getMessage());
         
        }
        return fileUpload;
    }
}
