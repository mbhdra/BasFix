<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>BasFix</title>
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

    <div class="row justify-content-left ">
      <div class="col-2 p-3">
        <p>Select an operation:</p>
          <form class="form-group" action="addUser">
            <button type="submit" class="btn btn-primary">Add User</button>
          </form>
          <br>
          <form class="form-group" action="addSeason">
            <button type="submit" class="btn btn-primary">Add Season</button>
          </form>
          <br>
          <form class="form-group" action="addDivision">
            <button type="submit" class="btn btn-primary">Add Division</button>
          </form>
          <br>
          <form class="form-group" action="addLeague">
            <button type="submit" class="btn btn-primary">Add League</button>
          </form>
          <br>
          <form class="form-group" action="addClub">
            <button type="submit" class="btn btn-primary">Add Club</button>
          </form>
          <br>
          <form class="form-group" action="addTeam">
            <button type="submit" class="btn btn-primary">Add Team</button>
          </form>
          <br>
          <form class="form-group" action="addSportsHall">
            <button type="submit" class="btn btn-primary">Add Sports Hall</button>
          </form>
          <br>
          <form class="form-group" action="addMatch">
            <button type="submit" class="btn btn-primary">Add Match</button>
          </form>
          <br>
          <form class="form-group" action="addTeamToLeague">
            <button type="submit" class="btn btn-primary">Add Teams to League</button>
          </form>
        </div>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
