package com.cognizant.moviecrusier.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cognizant.moviecrusier.util.DateUtil;

public class Movie {
	private long id;
	private String title;
	private int boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long id, String title, int boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(int boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hashTeaser) {
		this.hasTeaser = hashTeaser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat box = NumberFormat.getInstance();
		box.setGroupingUsed(true);

		return String.format("%-20s  $%20s  %-5s %-10s  %-15s %-5s Edit", title, box.format(boxOffice),
				active ? "Yes" : "No", sdf.format(dateOfLaunch), genre, isHasTeaser() ? "Yes" : "No");

	}

}
