/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author casa
 */
public class Constants { 
    private static String pathFilesWindows="C:\\Users\\casa\\Desktop\\netbeans-proyects\\MSXToolsWeb\\src\\main\\webapp\\files\\";
    private static String pathDBWindows="C:\\Users\\casa\\Desktop\\netbeans-proyects\\MSXToolsWeb\\src\\main\\webapp\\";
    private static String pathFilesUnix="/usr/local/tomcat/webapps/MSXToolsWeb/files/";
    private static String pathDBUnix="/usr/local/tomcat/webapps/MSXToolsWeb/";
    private static String operSys = System.getProperty("os.name").toLowerCase();
            
    public static String getPathFiles(){
        //if (operSys.contains("win")) {
                //return pathFilesWindows;
        //} else{
            return pathFilesUnix;
        //}
    }
    public static String getPathDB(){
        //if (operSys.contains("win")) {
                //return pathDBWindows;
        //} else{
            return pathDBUnix;
        //}
    }
}
