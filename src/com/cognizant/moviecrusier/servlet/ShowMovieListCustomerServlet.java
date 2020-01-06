package com.cognizant.moviecrusier.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieDao;
import com.cognizant.moviecrusier.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecrusier.model.Movie;

/**
 * Servlet implementation class ShowMovieListCustomerServlet
 */
@WebServlet({ "/ShowMovieListCustomerServlet", "/ShowMovieListCustomer" })
public class ShowMovieListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovieListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            MovieDao movieDao = new MovieDaoCollectionImpl();
            List<Movie> movieList=movieDao.getMovieListCustomer();
            request.setAttribute("movieList",movieList);
            RequestDispatcher rd=request.getRequestDispatcher("movie-list-customer.jsp");
            rd.forward(request,response);
     }catch(Exception e)
     {
            e.printStackTrace();
     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
