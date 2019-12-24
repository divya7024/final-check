package com.cognizant.moviecrusier.dao;

import java.util.List;

import com.cognizant.moviecrusier.dao.FavoriteDao;
import com.cognizant.moviecrusier.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecrusier.dao.FavoriteEmptyException;
import com.cognizant.moviecrusier.model.Movie;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {

		testGetAllFavorite();
		testGetAddFavorite();
		testGetAllFavorite();
		testRemoveFavorite();
		testGetAllFavorite();
		
	}

	private static void testGetAllFavorite() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		try{
			FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		
		List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
		System.out.println("Show All Favorite Items");
		for (Movie movie : movieListCustomer) {

			System.out.println(movie);
		}
		}catch(FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testGetAddFavorite() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();

		favoriteDao.addFavorite(1, 1L);
		favoriteDao.addFavorite(1, 4L);
		favoriteDao.addFavorite(1, 2L);
		favoriteDao.addFavorite(1, 3L);
		List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
		System.out.println("User Added Favorite List for Checkout");
		
		for (Movie movie : movieListCustomer) {
			System.out.println(movie);
		}
		
	}

	private static void testRemoveFavorite() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		System.out.println("Favorite List for Customer after Remove");
		try{
			favoriteDao.removeFavorite(1, 1L);
			favoriteDao.removeFavorite(1, 4L);

		List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
		for (Movie movie : movieListCustomer) {
			System.out.println(movie);
		}
		}catch(FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
