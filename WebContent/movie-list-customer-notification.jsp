<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Movie List customer notification</title>
	    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
    </head>
    <body>
		<header><span>Movie Cruiser</span>
		        <img src="./images/logo.png"/>
				<a id="favorites" href="ShowFavorite">Favorites</a>
		        <a id="movies" href="ShowMovieListCustomer">Movies</a>
	    </header>
		<div>
			   <h2 class="txt-left">Movies</h2>
			   <h3>Movie Added to Favorites successfully</h3>
			   <table class="cont">
		<tr>
			<th class="txt-left">Title</th>
			<th class="txt-right">Box Office</th>
	        <th class="txt-center">Genre</th>
			<th class="txt-center">Has Teaser</th>
			<th class="txt-center">Action</th>
		</tr>
		<c:forEach items="${movieList}" var="movie">
		<tr>
			<td class="txt-left">${movie.title}</td>
			<td class="txt-right">${movie.boxOffice}</td>
			<td class="txt-center">${movie.genre}</td>
			<td class="txt-right"><c:if test ="${movie.hasTeaser}">Yes</c:if>
                                  <c:if test="${!movie.hasTeaser}">No</c:if></td>
			<td class="txt-center"><c:if test ="${movie.active}">Yes</c:if>
	                               <c:if test="${!movie.active}">No</c:if></td></td>
			<td class="txt-center"><a href="AddToFavorite?movieId=${movie.id}" target="_blank">Add to Cart</a></td>
		</tr>
		</c:forEach>
		</table>
        </div>
        <footer><span>Copyright@2019</span></footer>
    </body>
</html>
			   