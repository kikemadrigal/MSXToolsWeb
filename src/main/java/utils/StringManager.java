/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author casa
 */
public class StringManager {
	

	
    /**
     * Devuelve true si encuentra el signo "<" en la cadena pasada por par�mtero
     * @param String
     * @return boolean
     */
    public static boolean buscarMenorQue(String cadena) {
            int posicionMenorQue=cadena.indexOf("<");
            //Si no ha encontrado el menor que devolver� falso
            if(posicionMenorQue ==-1) {
                    return false;
            }else {
                    return true;
            }
    }
    /**
     * Devuelve la cadena sin espacios execepto las que tienen un signo de excalamaci�n "!"
     * @param String
     * @return String
     */
    public static  String eliminarEspaciosYConservarExceptuados(String cadena, String[] excepted) {
            String textoSinEspacios="";
            //Si en la l�nea se encuaentra 1 admiraci�n entonces no borramos los espacios
            int posicionExceptuado0=cadena.indexOf(excepted[0]);
            int posicionExceptuado1=cadena.indexOf(excepted[1]);
            int posicionExceptuado2=cadena.indexOf(excepted[2]);
            //Si es distinto de menos uno se pueden borrar los espacios
            if(posicionExceptuado0==-1 & posicionExceptuado1==-1 & posicionExceptuado2==-1) {
            //if(posicionExceptuado0==-1 ) {
                    textoSinEspacios=cadena.replace(" ","");
            //Si da -1 es que no ha encontrado admiraciones y no se borran los espcios
            }else {
                //Borramos los símbolos exceptuados
                if(posicionExceptuado0!=-1)
                    textoSinEspacios=cadena.replace(excepted[0],"");
                if(posicionExceptuado1!=-1)
                    textoSinEspacios=cadena.replace(excepted[1],"");
                if(posicionExceptuado2!=-1)
                    textoSinEspacios=cadena.replace(excepted[2],"");
            }
            //Borramos la admiraci�n

            return textoSinEspacios;
    }
    /**
     * devuelve el n�mer de letras contenidas en un arrayList
     * @param arrayList
     * @return int
     */
    public static int getByteNumber(ArrayList<String> arrayList) {
            int bytes=0;
            for (String string: arrayList) {
                    bytes+=string.length();
            }
            return bytes;
    }

    /**
     * Esta funci�n quita las l�neas en las que parace el 1 ',1'
     * @param string
     * @return string
     */
    public static String formatearTexto(String cadena) {
            String textoSinUnoComa="";
            String textoFormateado="";
            //Si se ecuentra alguna coincidencia de 1'
            int posicionUnoComa=cadena.indexOf("1\'");
            int posicionUnoComaEspacio=cadena.indexOf("1 \'");
            int posicionUnoComaEspacioEspacio=cadena.indexOf("1  \'");
            if(posicionUnoComa ==-1 & posicionUnoComaEspacio==-1 & posicionUnoComaEspacioEspacio==-1) {
                    //Si no encuentra ninguna coincidencia entonces guardará ña frase
                    if(cadena!="" && cadena!=null && cadena.length()>0) {
                            textoFormateado=cadena;
                    }
            }
            return textoFormateado;
    }
    /**
     * Esta funci�n elimina los espacios y conserva los que tienen una admiraci�n
     * @param string
     * @return string
     */
    public String eliminarEspaciosYConservarAdmiracion(String cadena) {
            String textoSinEspacios="";
            //Si en la l�nea se encuaentra 1 admiraci�n entonces no borramos los espacios
            int posicionAdmiracion=cadena.indexOf("!");
            //Si es distinto de menos uno se pueden borrar los espacios
            if(posicionAdmiracion==-1) {
                    textoSinEspacios=cadena.replace(" ","");
            //Si da -1 es que no ha encontrado admiraciones y no se borran los espcios
            }else {
                    textoSinEspacios=cadena.replace("!","");
            }
            //Borramos la admiraci�n

            return textoSinEspacios;
    }


    /**
     * Devuelve true o false su encuenta un comentario
     * @param cadena
     * @return
     */
    public boolean buscarComentario(String cadena) {
            int posicionUnoComa=cadena.indexOf("1\'");
            int posicionUnoComaEspacio=cadena.indexOf("1 \'");
            int posicionUnoComaEspacioEspacio=cadena.indexOf("1  \'");
           
            
            if(posicionUnoComa ==-1 & posicionUnoComaEspacio==-1 & posicionUnoComaEspacioEspacio==-1) {
                    return false;
            }else {
                    return true;
            }
    }
    public boolean buscarComentarioConArray(String cadena, String[] comments) {
            int posicionUnoComa=cadena.indexOf(comments[0]);
            int posicionUnoComaEspacio=cadena.indexOf(comments[1]);
            int posicionUnoComaEspacioEspacio=cadena.indexOf(comments[2]);
            if(posicionUnoComa ==0 & posicionUnoComaEspacio==0 & posicionUnoComaEspacioEspacio==0) {
                    return false;
            }
            if(posicionUnoComa ==-1 & posicionUnoComaEspacio==-1 & posicionUnoComaEspacioEspacio==-1) {
                    return false;
            }else {
                    return true;
            }
    }

    public String introducirSaltosDeLinea(int longitudParaSalto, String texto) {
            String textResult="";
            for(int i=0;i<texto.length();i++) {
                    if (i % longitudParaSalto==0) {
                            textResult=texto.substring(0,i)+"\n";
                    }
            }
            return textResult;

    }

      

}
