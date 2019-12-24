package com.cognizant.moviecrusier.model;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecrusier.dao.FavoriteDao;
import com.cognizant.moviecrusier.dao.FavoriteEmptyException;

public class Favorite implements FavoriteDao {
	private static List<Movie> movieList;
	private double total;

	public Favorite() {
		super();
		movieList = new ArrayList<>();
		total = 0.0;
	}
	public Favorite(List<Movie> movieList, double total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}

	public static void setMovieList(List<Movie> movieList) {
		Favorite.movieList = movieList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public void addFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
