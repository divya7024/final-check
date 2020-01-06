<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Favorites</title>
	    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
    </head>
    <body>
		<header><span>Movie Cruiser</span>
		        <img src="./images/logo.png"/>
				<a id="favorites" href="ShowFavorite">Favorites</a>
		        <a id="movies" href="ShowMovieListCustomer">Movies</a>
	    </header>
		<div>
             <h1 class="cont">Favorites</h1>
             <h3>${msg}</h3>
        <table class="cont">
			<tr>
				<th class="txt-left">Title</th>
				<th class="txt-right">Box Office</th>
				<th class="txt-center">Genre</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
			<tr>
				<td class="txt-left">${movie.title}</td>
				<td class="txt-right">${movie.boxOffice }</td>
				<td class="txt-center">${movie.genre}</td>
				
				<td class="txt-center"><a href="RemoveFavorite?movieId=${movie.id}" target="_blank">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
        </div>
		<footer>
		    <span>Copyright@2019</span>
		</footer>
    </body>
</html>