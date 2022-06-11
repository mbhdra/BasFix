<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
            <div class="dropdown">
              <button class="btn btn-primary dropdown-toggle me-2" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                <security:authorize access="isAuthenticated()">
    		          <security:authentication property="principal.username" />
		            </security:authorize>
              </button>
              <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="/logout">Logout</a></li>
              </ul>
            </div>
          </div>
      </div>
    </nav>

    <br><br><br><br><br><br>
    <form action="addSeason" method="post">
      <div class="row justify-content-center ">
        <div class="col-4 border p-3 bg-light">

          <div class="form-group pb-3">
            <label for="startingYear">Starting Year:</label>
            <input type="text" name="startingYear" class="form-control" id="startingYear" placeholder="Starting Year" required pattern="[0-9]+" title="Enter a number!">
          </div>

          <div class="form-group pb-3">
            <label for="endingYear">Ending Year:</label>
            <input type="text" name="endingYear" class="form-control" id="endingYear" placeholder="Ending Year" required pattern="[0-9]+" title="Enter a number!">
          </div>
          <button type="submit" class="btn btn-primary">Add Season</button>
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

    <% if (request.getAttribute("feedback") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#exampleModal').modal('show'); }); </script>
    <%	} %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
