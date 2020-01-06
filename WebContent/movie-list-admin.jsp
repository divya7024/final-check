<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
	<head>
		<title>Movie List Admin</title>
	    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
    </head>
    <body>
		<header><span>Movie Cruiser</span>
		        <img src="./images/logo.png"/>
		        <a id="movies" href="ShowMovieListAdmin">Movies</a>
	    </header>
		<div>
			<h2 class="txt-left">Movies</h2>
			<table class="cont">
					<tr>
						<th class="txt-left">Title</th>
						<th class="txt-right">Box Office</th>
						<th class="txt-center">Active</th>
						<th class="txt-center">Date of Launch</th>
						<th class="txt-center">Genre</th>
						<th class="txt-center">Has Teaser</th>
						<th class="txt-center">Action</th>
					</tr>
					<c:forEach items="${movieList}" var="movie">
					<tr>
					
						<td class="txt-left">${movie.title}</td>
						<td class="txt-right">${movie.boxOffice}</td>
						<td class="txt-center"><c:if test="${movie.active}">Yes</c:if>
							<c:if test="${!movie.active}">No</c:if></td>
						<td class="txt-center"><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}"></fmt:formatDate></td>
						<td class="txt-center">${movie.genre}</td>
						<td class="txt-center"><c:if test="${movie.hasTeaser}">Yes</c:if>
							<c:if test="${!movie.hasTeaser}">No</c:if></td>
						<td class="txt-center"><a href="ShowEditMovie?movieId=${movie.id}" target="_blank">Edit</a></td>
						
					</tr>
					</c:forEach>
				</table>
		</div>
    <footer>
     <span>Copyright@2019</span>  
    </footer>
    </body>
</html>

    

					