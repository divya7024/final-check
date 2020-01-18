package com.cognizant.moviecrusier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecrusier.model.Favorite;
import com.cognizant.moviecrusier.model.Movie;

public class FavoriteDaoSqlImpl implements FavoriteDao{

	@Override
	public void addFavorite(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();	
		try {
			String sql = "INSERT INTO favorites(fv_us_id,fv_pr_id) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1,userId);
			ps.setLong(2,movieId);
			int result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	

	@Override
	public void removeFavorite(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "DELETE FROM favorites \r\n" + 
					"\r\n" + 
					"WHERE fv_us_id=? AND fv_pr_id=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1,userId);
			ps.setLong(2, movieId);
			int result=ps.executeUpdate();
			
		}catch (Exception ex) {
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
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		List<Movie> favoriteList=new ArrayList<>();
	    Favorite favorite=new Favorite();
	    
	    		Connection con=ConnectionHandler.getConnection();
		try {
			String sql= "SELECT mv_id,mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser FROM movie_list INNER JOIN favorites ON fv_pr_id=mv_id WHERE fv_us_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1,userId);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));
				m.setBoxOffice(rs.getInt(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6));
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("yes"));
				favoriteList.add(m);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return favoriteList;
		}
			
		
		
	
	

	@Override
	public List<Movie> getMovieList() {
		
		return null;
	}

	@Override
	public void setTotal(double total) {
		
		
	}

}
