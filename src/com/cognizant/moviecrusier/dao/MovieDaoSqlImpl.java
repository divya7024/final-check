package com.cognizant.moviecrusier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;

public class MovieDaoSqlImpl implements MovieDao {

	@Override
	public List<com.cognizant.moviecrusier.model.Movie> getMovieListAdmin() {
		List<Movie> movieList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();

		String sql = "SELECT mv_id  ,mv_title,mv_box_office ,mv_active ,mv_date_of_launch,mv_genre, mv_has_teaser  FROM movie_list";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));
				m.setBoxOffice(rs.getInt(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6));
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));

				movieList.add(m);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return movieList;
	}

	@Override
	public List<com.cognizant.moviecrusier.model.Movie> getMovieListCustomer() {
		List<Movie> customerList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		String sql ="SELECT mv_id,mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser FROM movie_list WHERE mv_active=? AND mv_date_of_launch<=?";
				try {

					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, "Yes");
					java.util.Date d = new java.util.Date();
					ps.setDate(2, new java.sql.Date(d.getTime()));
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Movie m = new Movie();
						m.setId(rs.getInt(1));
						m.setTitle(rs.getString(2));
						m.setBoxOffice(rs.getInt(3));
						m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
						m.setDateOfLaunch(rs.getDate(5));
						m.setGenre(rs.getString(6));
						m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));

						customerList.add(m);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				return customerList;
	}

	@Override
	public void EditMovie(Movie movie) {
		List<Movie> movieList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();

		String sql ="UPDATE movie_list SET mv_title=?,mv_box_office=?,mv_active=?,mv_date_of_launch=?,mv_genre=?,mv_has_teaser=? WHERE mv_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movie.getTitle());
			ps.setFloat(2, movie.getBoxOffice());
			ps.setString(3, movie.isActive() ? "Yes" : "No");
			ps.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
			ps.setString(5, movie.getGenre());
			ps.setString(6, movie.isHasTeaser() ? "Yes" : "No");
			ps.setLong(7, movie.getId());
			int result = ps.executeUpdate();

			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	

	@Override
	public com.cognizant.moviecrusier.model.Movie getMovie(Long movieId) {
		Movie movie = new Movie();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "SELECT \r\n" + 
					"\r\n" + 
					"mv_id AS Id ,\r\n" + 
					"\r\n" + 
					"mv_title AS Title,\r\n" + 
					"\r\n" + 
					"mv_box_office AS Box_Office,\r\n" + 
					"\r\n" + 
					"mv_active AS Active,\r\n" + 
					"\r\n" + 
					"mv_date_of_launch AS Date_Of_Launch,\r\n" + 
					"\r\n" + 
					"mv_genre As Genre,\r\n" + 
					"\r\n" + 
					"mv_has_teaser AS Has_Teaser\r\n" + 
					"\r\n" + 
					" FROM movie_list;\r\n" + 
					"Where mv_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));
				m.setBoxOffice(rs.getInt(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6));
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return movie;
		
	
	}

	@Override
	public void Movie(com.cognizant.moviecrusier.model.Movie movie) {
		// TODO Auto-generated method stub
		
	}

}
