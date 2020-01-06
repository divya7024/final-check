package com.cognizant.moviecrusier.dao;

import com.cognizant.moviecrusier.model.Movie;
import java.util.List;

public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void EditMovie(Movie movie);

	public Movie getMovie(Long movieId);

	void Movie(Movie movie);

	

}
