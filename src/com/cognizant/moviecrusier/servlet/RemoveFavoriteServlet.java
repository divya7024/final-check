package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.FavoriteDao;
import com.cognizant.moviecrusier.dao.FavoriteDaoCollectionImpl;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet({ "/RemoveFavoriteServlet", "/RemoveFavorite" })
public class RemoveFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FavoriteDao favoriteDao=new FavoriteDaoCollectionImpl();
			long movieId=Long.parseLong(request.getParameter("movieId"));
			favoriteDao.removeFavorite(1, movieId);
			request.setAttribute("msg","Movie removed from Favorites successfully");
			RequestDispatcher rd=request.getRequestDispatcher("ShowFavorite");
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
