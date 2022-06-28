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
    <form action="selectLeagueToAddMatch" method="post">
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
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
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
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
          </div>
    	</div>
  	  </div>
	</div>
	
	<div class="modal fade" id="selectTeamsModal" tabindex="-1" aria-labelledby="selectTeamsModalLabel" aria-hidden="true">
  	  <div class="modal-dialog">
    	<div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="selectTeamsModalLabel">Add Match</h5>
            <form class="form-group" action="addMatch">
            	<button type="submit" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </form>
          </div>
          <div class="modal-body">
            <form action="addMatch" method="post">
              <input type="hidden" name="league" value="${league.leagueId}">
              <div class="form-group pb-3">
                <label for="ateam">A Team:</label>
			    <select class="form-select" name="aTeam">
        	      <c:forEach items="${teams}" var="team">
                    <option value="${team.teamId}">${team.teamName}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group pb-3">
                <label for="ateam">B Team:</label>
			    <select class="form-select" name="bTeam">
        	      <c:forEach items="${teams}" var="team">
                    <option value="${team.teamId}">${team.teamName}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group pb-3">
                <label for="date">Sports Hall:</label>
			    <select class="form-select" name="sportsHall">
        	      <c:forEach items="${sportsHalls}" var="sportsHall">
                    <option value="${sportsHall.sportsHallId}">${sportsHall.sportsHallName}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="row justify-content-center">
                <div class="col form-group">
                  <label for="date">Date:</label><br>
			      <input type="date" name="date" required>
                </div>
                <div class="col form-group pb-3">
                  <label for="time">Time:</label><br>
			      <select id="time" name="time"></select>
                </div>
              </div>
              <button type="submit" class="btn btn-primary" id="addMatchButton">Add Match</button>
            </form>
          </div>
    	</div>
  	  </div>
	</div>
	
	
	<% if (request.getAttribute("failureFeedback") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#failureModal').modal('show'); }); </script>
    <%	} %>
    <% if (request.getAttribute("successFeedback") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#successModal').modal('show'); }); </script>
    <%	} %>
    <% if (request.getAttribute("league") != null){ %>
    	<script type="text/javascript"> $(document).ready(function(){ $('#selectTeamsModal').modal('show'); }); </script>
    	<script type="text/javascript">

    		function createOption(value, text) {
            	var option = document.createElement('option');
              	option.text = text;
              	option.value = value;
              	return option;
       		}

       		var hourSelect = document.getElementById('time');
       		for(var i = 9; i <= 21; i++){
    	   		if(i%3==0)
              		hourSelect.add(createOption(String(i).concat(":00"), String(i).concat(":00")));
    	   		else if(i%3==1)
              		hourSelect.add(createOption(String(i).concat(":30"), String(i).concat(":30")));
       		}
       </script>
    <%	} %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
