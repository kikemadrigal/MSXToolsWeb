/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author casa
 */
public class DeleteComments {
    private FileManager filemanager;
    private StringManager stringManager;
    private File fileOrigin;
    private File fileDestiny;

    public DeleteComments(FileManager filemanager,StringManager stringManager) {
        this.filemanager=filemanager;
        this.stringManager=stringManager;
    }
    


    public File convertNameDestinyLess(File fileOrigin, String[] comments, String[] excepted) { 
        System.out.println("Vamos a convertir el archivo: "+fileOrigin.getAbsolutePath());
        ArrayList<String> arrayList=filemanager.readFile(fileOrigin);
        System.out.println("El tama�o del array con el texto sin formatear es : "+arrayList.size());
        ArrayList<String>arrayListFormatTexts=deleteComents(arrayList,comments,excepted);
        System.out.println("El tama�o del array con el texto formateado es : "+arrayListFormatTexts.size());
        String newNameFileDestiny=fileOrigin.getName().substring(0,fileOrigin.getName().length()-4)+"-del.bas";
        File fileDestiny=new File(fileOrigin.getParent()+"\\"+newNameFileDestiny);
        filemanager.writeFile(fileDestiny, arrayListFormatTexts);
        return fileDestiny;
    }
    
    public void converterWithFileDestiny(File fileOrigin, File fileDestiny, String[] comments, String[] excepted) {
        //System.out.println("Vamos a borrar el archivo: "+fileOrigin.getAbsolutePath()+" en el archivo "+fileDestiny.getAbsolutePath());
        ArrayList<String> arrayList=filemanager.readFile(fileOrigin);
        System.out.println(" Delete comments dice: origen "+fileOrigin.getAbsolutePath()+" destino "+fileDestiny.getAbsolutePath());
        System.out.println(" Delete comments dice: leidos "+arrayList.size());
        System.out.println(" Delete comments dice: readfile "+arrayList.size());
        ArrayList<String>arrayListFormatTexts=deleteComents(arrayList,comments,excepted);
        filemanager.writeFile(fileDestiny, arrayListFormatTexts);
    }

    private ArrayList<String> deleteComents(ArrayList<String> arrayList, String[] comments, String[] excepted) {
        String fomartText="";
        ArrayList<String> arrayListFormatTexts=new ArrayList<String>();
        for (String linea:arrayList) {
            linea=stringManager.eliminarEspaciosYConservarExceptuados(linea, excepted);
            //Si encuentra un 1' o 1 ' o 1  ' simplemente no escribe esa l�nea
            if (!stringManager.buscarComentarioConArray(linea, comments)) {
                if(linea!="" && linea!=null && linea.length()>0) {
                        fomartText=linea;
                        arrayListFormatTexts.add(linea);
                }
            }
        }
        return arrayListFormatTexts;
    }
      
    	

    
     
    
}
