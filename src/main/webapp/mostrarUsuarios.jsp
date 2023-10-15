<%-- 
    Document   : mostrarUsuarios
    Created on : 15 oct. 2023, 4:58:27
    Author     : casa
--%>

<%@page import="Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar usuarios</title>
    </head>
    <body>
        <h1>MSXTools web</h1>
        <% 
            List<Usuario> listaUsuarios=(List) request.getSession().getAttribute("listaUsuarios");
            int cont=1;
            for(Usuario usu:listaUsuarios){
        %>
        <p><b>Cliente Nº<%=cont%></b></p>
        <p>DNI:<%=usu.getDni()%></p>
        <p>nombre:<%=usu.getNombre()%></p>
        <p>Apellido:<%=usu.getApellido()%></p>
        <p>Telefono:<%=usu.getTelefono()%></p>
        <p>---------------------------</p>
        <% cont++; %>
        <%  }  %>
    </body>
</html>
