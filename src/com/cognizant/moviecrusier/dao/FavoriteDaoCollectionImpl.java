
package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecrusier.model.Favorite;
import com.cognizant.moviecrusier.model.Movie;


public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, FavoriteDao> userFavorites;

	public FavoriteDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1l, new Favorite());
		}
	}

	@Override
	public void addFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movie = movieDao.getMovie(movieId);
			if (userFavorites.containsKey(userId)) {
				FavoriteDao favorite = userFavorites.get(userId);
				favorite.getMovieList().add(movie);
			} else {
				Favorite favorite = new Favorite();
				favorite.getMovieList().add(movie);
				userFavorites.put(userId, favorite);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		List<Movie> movieList = userFavorites.get(userId).getMovieList();
		FavoriteDao favorite = userFavorites.get(userId);
		double total = 0.0;
		if (favorite == null || favorite.getMovieList() == null || movieList.isEmpty()) {
			throw new FavoriteEmptyException();
		} else {
			for (Movie movie : movieList) {
				total += movie.getBoxOffice();
			}
		}
		favorite.setTotal(total);
		return movieList;

	}

	@Override
	public void removeFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		List<Movie> movieList = userFavorites.get(userId).getMovieList();
		
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieList.remove(i);
			}

		}
	}

	@Override
	public List<Movie> getMovieList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTotal(double total) {
		// TODO Auto-generated method stub
		
	}

	
	
}
