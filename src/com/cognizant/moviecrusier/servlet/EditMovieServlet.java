package com.cognizant.moviecrusier.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieDao;
import com.cognizant.moviecrusier.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("servled at:").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long id = Integer.parseInt(request.getParameter("movieId"));
		
			String title = request.getParameter("txtTitle");
			int boxOffice = Integer.parseInt(request.getParameter("txtGross"));
			boolean active = request.getParameter("rdActive").equalsIgnoreCase("yes");
			String dateOfLaunch = request.getParameter("txtDoL");
			String genre = request.getParameter("genre");
			boolean hasTeaser =  request.getParameter("hasTeaser").equalsIgnoreCase("yes");
			Movie m = new Movie(id,title, boxOffice, active,DateUtil.convertToDate(dateOfLaunch),genre,hasTeaser);
			MovieDao movieDao = new MovieDaoCollectionImpl();

			movieDao.EditMovie(m);
			request.setAttribute("msg", "Movie details saved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
