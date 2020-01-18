package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

public class MovieDaoSqlImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("Admin Movie List");
			testGetMovieListAdmin();

			System.out.println("Customer Movie List");
			testGetMovieListCustomer();
			testEditMovie();

			System.out.println("Modify Movie List");
			testGetMovieListAdmin();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void testEditMovie() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		Movie movie = new Movie(1, "Bahubali", 12345678, false, DateUtil.convertToDate("17/08/2018"), "Historic", false);
		movieDao.EditMovie(movie);

		
	}

	private static void testGetMovieListCustomer() {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> customerList = movieDao.getMovieListCustomer();
		for (Movie x : customerList) {
			System.out.println(x);
		}
	}

	private static void testGetMovieListAdmin() {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}
		
	}

}
