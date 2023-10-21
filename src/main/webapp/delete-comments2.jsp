<%-- 
    Document   : deletecoments
    Created on : 18 oct. 2023, 7:39:55
    Author     : casa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.FileUpload"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>MSXTools web</title>
  </head>
     <body>
         <div class="container">
             <div class="row">
                 <div class="column">
                     <h3>Delete comments & spaces->show file</h3><br>
                     <a href="delete-comments.jsp" class="btn btn-outline-primary m-4">Volver</a>
                 </div>
            </div>
            
            <div class="row">
                 <div class="column">
                     
                        <% 
                           
                            if(request.getSession().getAttribute("arrayListText") == null)
                            {
                        %><p>empty file</p><%
                               //fileList.add(new FileUpload(0,"","List empty"));
                               //System.out.println("No hay datos de este archivo");
                            }else{
                               FileUpload fileUpload=(FileUpload)request.getSession().getAttribute("fileUpload");
                         %><a href='https://msxtoolsweb.onrender.com/files/<%=fileUpload.getName()+".zip"%>'>Download</a><br><br><br><%
                               // System.out.println("el array tiene "+String.valueOf(fileList.size()));
                               ArrayList<String> arrayListfileUploadText=(ArrayList<String>) request.getSession().getAttribute("arrayListText");
                        
                               for (String line:arrayListfileUploadText){
                        %>
                                    <%=line%><br>
                        <%  
                                                          
                               } 
                            }
                        %>
                 </div>
            </div> 
        </div><!-- Final div container-->
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        -->
  </body>
</html>
</html>
