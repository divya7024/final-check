package com.cognizant.moviecrusier.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.FavoriteDao;
import com.cognizant.moviecrusier.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecrusier.model.Movie;

/**
 * Servlet implementation class ShowFavoriteServlet
 */
@WebServlet({ "/ShowFavoriteServlet", "/ShowFavorite" })
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteDao favoriteDao =new FavoriteDaoCollectionImpl();
		try{
			List<Movie>favorite=favoriteDao.getAllFavorite(1);
			
			double total=0;
			for(Movie movie:favorite) {
				total +=movie.getBoxOffice();
			}
			request.setAttribute("movieList",favorite);
			request.setAttribute("total",total);
			RequestDispatcher rd=request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
			
			}catch(Exception e) {
				RequestDispatcher rd=request.getRequestDispatcher("favorites-empty.jsp");
				rd.forward(request, response);
			
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
