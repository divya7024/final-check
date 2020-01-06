<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Edit Movie</title>
	    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
		<script src="./js/script.js" type="text/javascript"></script>
    </head>
    <body>
		<header><span>Movie Cruiser</span>
		        <img src="./images/logo.png"/>
		        <a id="movies" href="ShowMovieListAdmin">Movies</a>
	    </header>
		<div>
                <h2 class="cont">Edit Movie</h2>
                 <form class="cont" name="form" onSubmit="return validation()" method="post" action="EditMovie?movieId=${movie.id}">
		           <table>
						<tr rowspan="4">
							<td colspan="4">
							<label for="txtTitle">Title</label></td>
						</tr>
						<tr>
                            <td colspan="4"><input type="text" id="txtTitle" name="txtTitle" size="140" value="${movie.title }"></td>
                        </tr>
						<tr>
							 <th class="txt-left"><label for="txtGross">Gross(S)</label></th>
							 <th class="txt-left">Active</th>
							 <th class="txt-left"><label for="txtDoL">Date of Launch</label></th>
							 <th class="txt-left"><label for="genre">Genre</label></th>
						</tr>
						<tr>
                            <td><input type="textbox"  id="txtGRoss" name="txtGross"class="txt-right" value="${movie.boxOffice}"/></td>
							
							<td><label for="rdYes">
								<input type="radio" id="rdYes" name="rdActive" value="Yes" <c:if test="${movie.active eq 'true'}"> checked="checked"</c:if>>Yes</label>
								<label for="rdNo">
								<input type="radio" id="rdNo" name="rdActive" value="No" <c:if test="${movie.active eq 'false'}"> checked="checked" </c:if>>No</label></td>
                            
                            <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}" var="format"/>
							<input type="text" id="txtDoL" name="txtDoL" value="${format}"/></td>
							
							
                            <td><select name="genre" id="Genre">
								<option>Science Fiction</option>
								<option>Super hero</option>
								<option>Romance</option>
								<option>Comedy</option>
								<option>Adventure</option>
								<option>Thriller</option>
                            </td>
                        
						<tr>
                            <td> <input type="checkbox" name="hasTeaser" id="hasTeaser" value="${movie.hasTeaser}" 
							<c:if test="${movie.hasTeaser eq 'true'}"> checked="checked"</c:if>
							<c:if test="${!movie.hasTeaser eq 'false'}">checked="checked"</c:if>/>HasTeaser</td>
                        </tr>
						<tr>
                            <td  colspan="2"><input class="color" type="submit" value="Save" ></a></td>
                        </tr>
				  </table>
				  </form>
        </div>
			<footer>
			 <span>Copyright@2019</span>  
			</footer>
    </body>
</html>				  