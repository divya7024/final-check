package com.cognizant.moviecrusier.dao;

import java.util.List;

import com.cognizant.moviecrusier.model.Movie;


public interface FavoriteDao {
	public void addFavorite(long userId, long movieId);

	public void removeFavorite(long userId, long movieId);

	public List<Movie>getAllFavorite(long userId)throws FavoriteEmptyException;

	public List<Movie> getMovieList();

	public void setTotal(double total);
}
