<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <form action="selectLeague" method="post">
      <div class="row justify-content-center ">
        <div class="col-4 border p-3 bg-light">
              
          <div class="form-group pb-3">
            <select class="form-select" name="league">
        	  <c:forEach items="${leagues}" var="league">
                <option value="${league.leagueId}">${league.leagueName}</option>
              </c:forEach>
            </select>	
          </div>

          <button type="submit" class="btn btn-primary">Select League</button>
        </div>
      </div>
    </form>

	<div class="modal fade" id="atLestOneTeamModal" tabindex="-1" aria-labelledby="atLestOneTeamModalLabel" aria-hidden="true">
  	  <div class="modal-dialog">
    	<div class="modal-content">
      	  <div class="modal-header">
        	<h5 class="modal-title" id="atLestOneTeamModalLabel">Feedback</h5>
        	<form class="form-group" action="addTeamToLeague">
        		<button type="submit" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        	</form>
      	  </div>
      	  <div class="modal-body">
          	You must select at least 1 team!
      	  </div>
      	  <div class="modal-footer">
      	  	<form class="form-group" action="addTeamToLeague">
        	  <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
        	</form>
      	  </div>
    	</div>
  	  </div>
	</div>
	
	<div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successModalLabel" aria-hidden="true">
  	  <div class="modal-dialog">
    	<div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="successModalLabel">Feedback</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ${successFeedback}
          </div>
          <div class="modal-footer">
          <div class="row"></div>
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
          </div>
    	</div>
  	  </div>
	</div>
	
	<div class="modal fade" id="failureModal" tabindex="-1" aria-labelledby="failureModalLabel" aria-hidden="true">
  	  <div class="modal-dialog">
    	<div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="failureModalLabel">Feedback</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ${failureFeedback}
          </div>
          <div class="modal-footer">
          <div class="row"></div>
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
          </div>
    	</div>
  	  </div>
	</div>
	
	<div class="modal fade" id="selectTeamsModal" tabindex="-1" aria-labelledby="selectTeamsModalLabel" aria-hidden="true">
  	  <div class="modal-dialog">
    	<div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="selectTeamsModalLabel">Select Teams</h5>
            <form class="form-group" action="addTeamToLeague">
            	<button type="submit" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </form>
          </div>
          <div class="modal-body">
            <form class="form-group" action="addTeamToLeague" method="post">
              <input type="hidden" name="league" value="${league.leagueId}">
	          <c:forEach items="${teams}" var="team">
          		<input type="checkbox" name="selectedTeams" value="${team.teamId}"> ${team.teamName} <br>
          	  </c:forEach>
          	  <br>
              <button type="submit" class="btn btn-primary" id="addTeamButton" data-bs-dismiss="modal">Add Selected Teams</button>
            </form>
          </div>
    	</div>
  	  </div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function () {
    		$('#addTeamButton').click(function() {
      			checked = $("input[type=checkbox]:checked").length;

      			if(!checked){
      				$('#atLestOneTeamModal').modal('show');
      				return false;
      			}
    		});
		});
	</script>
	
	<% if (request.getAttribute("successFeedback") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#successModal').modal('show'); }); </script>
    <%	} %>
    	<% if (request.getAttribute("failureFeedback") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#failureModal').modal('show'); }); </script>
    <%	} %>
    <% if (request.getAttribute("league") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#selectTeamsModal').modal('show'); }); </script>
    <%	} %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
