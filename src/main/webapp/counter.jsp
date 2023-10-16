<%-- 
    Document   : Counter
    Created on : 16 oct. 2023, 3:35:17
    Author     : casa
--%>

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
        <h3>Counter</h3>
        <%
          String text="";
          String lenghtWord="0";
          String lenghtLines="0";
          if(request.getSession().getAttribute("text") != null)
          {
            text=request.getSession().getAttribute("text").toString();
            lenghtWord=request.getSession().getAttribute("lenghtWord").toString();
            lenghtLines=request.getSession().getAttribute("lenghtLines").toString();
          }
        %>
        <a href="index.html" class="btn btn-outline-primary m-4">Volver</a>
        <form action="SvCounter" method="GET" class="p-4">
            <div class="mb-3">
                <label for="text" class="form-label">Enter the text</label>
                <textarea class="form-control" name="text" id="text" rows="10">${text}</textarea>
            </div>
            <div class="mb-3">
                <label for="cut" class="form-label">Number of lines to save</label>
                <input type="text" rows="50" class="form-control" name="cut" id="cut" placeholder="0" value="0">
            </div>
            <div class="mb-3 p-4">
                <button type="submit" class="btn btn-outline-dark">Get lenght</button>
                <!--<button type="submit" class="btn btn-outline-dark">Cut!!</a>-->
            </div>
        </form>

        </form>
        <div class="p-4">
            <label class="form-label">Letter length: </label>
            <input type="text" value="${lenghtWord}"><br>
            <label class="form-label">Line length: </label>
            <input type="text" value="${lenghtLines}">
        </div>
    </div><!--Final div container-->
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