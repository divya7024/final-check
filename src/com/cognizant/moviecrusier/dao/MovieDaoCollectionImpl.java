package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() throws ParseException {
		super();
		if (movieList == null) {
			movieList = new ArrayList<>();
			movieList.add(new Movie(1, "Avatar", 278796508, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "The Avengers", 151812988, true, DateUtil.convertToDate("23/12/2017"),
					"Romance", true));
			movieList.add(new Movie(3, "Titanic", 218746394, true, DateUtil.convertToDate("21/08/2017"),
					"Comedy", true));
			movieList.add(new Movie(4, "Jurassic World", 1671713208, false, DateUtil.convertToDate("02/07/2017"),
					"Adventure", true));
			movieList.add(new Movie(5, "Avengers:End Game", 275076034, true, DateUtil.convertToDate("02/11/2022"),
					"Thriller", true));
		}
	}

	@Override
	public List<com.cognizant.moviecrusier.model.Movie> getMovieListAdmin() {
		return movieList;

	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> customerList = new ArrayList<>();
		Date today = new Date();
		for (Movie x : movieList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				customerList.add(x);

			}
		}
		return customerList;

	}

	@Override
	public void Movie(com.cognizant.moviecrusier.model.Movie movie) {

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movie.getId()) {
				movieList.set(i, movie);
			}
			
		}

	}

	@Override
	public com.cognizant.moviecrusier.model.Movie getMovie(Long movieId) {

		Movie movie = null;

		for (Movie x : movieList) {
			if (x.getId() == movieId) {
				movie = x;
				break;
			}
		}
		return movie;
	}

	@Override
	public void EditMovie(com.cognizant.moviecrusier.model.Movie movie) {
		// TODO Auto-generated method stub
		Movie x = getMovie((movie).getId());

		x.setTitle(movie.getTitle());
		x.setBoxOffice(movie.getBoxOffice());
		x.setActive(movie.isActive());
		x.setDateOfLaunch(movie.getDateOfLaunch());
		x.setGenre(movie.getGenre());
		x.setHasTeaser(movie.isHasTeaser());

	}

}
