<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>BasFix</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
  <body class="bg-secondary bg-opacity-25">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">BasFix</a>
          <div class="navbar-nav">
            <form class="container-fluid justify-content-start" action="/loginSubmit" >
              <button class="btn btn-primary me-2" type="submit">Login</button>
            </form>
          </div>
      </div>
    </nav>

    <br><br><br><br><br><br>
    <form action="login" method="post">
      <div class="row justify-content-center ">
        <div class="col-4 border p-3 bg-light">

          <div class="form-group pb-3">
            <label for="username1">Username:</label>
            <input type="text" name="username" class="form-control" id="username1" placeholder="Enter username" required>

          </div>
          <div class="form-group pb-3">
            <label for="password1">Password:</label>
            <input type="password" name="password" class="form-control" id="password1" placeholder="Password" required>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </div>
    </form>
    
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  	  <div class="modal-dialog">
    	<div class="modal-content">
      	  <div class="modal-header">
        	<h5 class="modal-title" id="exampleModalLabel">Feedback</h5>
        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      	  </div>
      	  <div class="modal-body">
          	${feedback}
      	  </div>
      	  <div class="modal-footer">
        	<button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
      	  </div>
    	</div>
  	  </div>
	</div>

    <% if (request.getAttribute("feedback") != null){%>
    	<script type="text/javascript"> $(document).ready(function(){ $('#exampleModal').modal('show'); }); </script> 
    <%	} %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
