package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecrusier.dao.MovieDao;
import com.cognizant.moviecrusier.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

public class MovieDaoColloectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("Admin movie list");
			testGetMovieListAdmin();
			System.out.println("Customer movie list");
			testGetMovieListCustomer();
			testEditMovie();
			System.out.println("Edit movie list");
			testGetMovieListAdmin();

		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}
	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> customerList = movieDao.getMovieListCustomer();
		for (Movie x : customerList) {
			System.out.println(x);
		}
	}

	private static void testEditMovie() throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = new Movie(1, "Bahubali", 12345678, false, DateUtil.convertToDate("17/08/2018"), "Historic", false);
		movieDao.EditMovie(movie);

	}

}
