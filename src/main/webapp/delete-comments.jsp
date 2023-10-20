<%-- 
    Document   : deletecoments
    Created on : 18 oct. 2023, 7:39:55
    Author     : casa
--%>

<%@page import="database.SQLiteClient"%>
<%@page import="models.FileUpload"%>
<%@page import="java.util.ArrayList"%>
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
                     <h3>Delete comments & spaces</h3><br>
                     <a href="index.html" class="btn btn-outline-primary m-4">Volver</a>
                 </div>
            </div>
            <div class="row">
                 <div class="col border border-primary">
                     
                    <form method='post' action='SvInsertFileUpload' class='form-horizontal' enctype='multipart/form-data'>
                        <div class="text-center">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class='form-group m-4' >
                                        <label for='file' class='control-label'>File.bas: </label> 
                                        <input type='file' class='form-control' name='file' id='file' placeholder="Selecciona el archivo.bas"/>
                                    </div>
                                </div>
                            </div> 
                            <div class="row">
                                <div class="col-md-4">
                                    <div class='form-group m-4' >
                                        <label for='comment1' class='control-label'>Cometario 1 empieza por: </label> 
                                        <input type='text' class='form-control' name='comment1' id='comment1' placeholder="1'" value="1'"/>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                   <div class='form-group m-4' >
                                        <label for='comment2' class='control-label'>Cometario 2 empieza por: </label> 
                                        <input type='text' class='form-control' name='comment2' id='comment2' placeholder="1 '" value="1 '"/>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class='form-group m-4' >
                                        <label for='comment3' class='control-label'>Cometario 3 empieza por: </label> 
                                        <input type='text' class='form-control' name='comment3' id='comment3' placeholder="1  '" value="1  '"/>
                                    </div>
                                </div>
                            </div>
                            
                            
                            <div class="row">
                                <div class="col-md-4">
                                     <div class='form-group m-4' >
                                        <label for='excepted1' class='control-label'>Exceptuado 1 empieza por: </label> 
                                        <input type='text' class='form-control' name='excepted1' id='excepted1' placeholder="!" value="!"/>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class='form-group m-4' >
                                        <label for='excepted2' class='control-label'>Exceptuado 2 empieza por: </label> 
                                        <!-- Alt+156=£, alt+189=¢ -->
                                        <input type='text' class='form-control' name='excepted2' id='excepted2' placeholder="£" value="£"/>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class='form-group m-4' >
                                        <label for='excepted3' class='control-label'>Exceptuado 3 empieza por: </label> 
                                        <input type='text' class='form-control' name='excepted3' id='excepted3' placeholder="¢" value="¢"/>
                                    </div>
                                </div>
                           </div>

                        
                            <div class='form-group m-4' > 
                                <div class='col col-md-offset-2' >
                                    <input type='submit' name='submit'  id='submit' value='Convert' class='btn btn-primary' />
                                </div>
                            </div> 
                    
                        </div><!--Final del div text center-->
                    </form> 
                </div>
            </div>
            <div class="row">
               <div class="col ">
                    <br>
               </div>
            </div>
            <div class="row">
                 <div class="col border border-dark">
                    <h5>Download</h5><br>
                     <table class="table table-info table-striped table-hover">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Actiom</th>
                          </tr>
                        </thead>
                        <tbody>
                        <% 
                            SQLiteClient sqliteClient=new SQLiteClient(); 
                            ArrayList<FileUpload> listFiles=sqliteClient.getAllFilesDataBase();

                            if(listFiles == null)
                            {
                        %><p>empty list</p><%
                            }else{
                                
                        %><p>Size list:<%=listFiles.size()%> </p><%
                               for(FileUpload file : listFiles){
                        %>

                                <tr>
                                  <td>Id:<%=file.getId()%></td>
                                  <td>File: <a href="SvShowFileUpload?id=<%=file.getId()%>"> <%=file.getName()%> </a></td>
                                  <td>
                                        <form method='POST' action='SvDeleteFileUpload'>
                                             <input type='hidden' name='id' id='id' value='<%=file.getId()%>' />
                                             <input type='submit' value='X' class='btn btn-danger' />
                                        </form>
                                  </td>
                                </tr>
                        
  
                        <%  
                              }                             
                            } 
                        %>
                          </tbody>
                        </table>
                        
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
