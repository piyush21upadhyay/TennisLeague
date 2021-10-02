package com.sageconsulting.util;

public class SortSeason {

	String name;
	String gender;
	String playingPref;
	double rating;

	public SortSeason(String name, String gender, String playingPref, double rating) {
		super();
		this.name = name;
		this.gender = gender;
		this.playingPref = playingPref;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPlayingPref() {
		return playingPref;
	}

	public void setPlayingPref(String playingPref) {
		this.playingPref = playingPref;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "SortSeason [name=" + name + ", gender=" + gender + ", playingPref=" + playingPref + ", rating=" + rating
				+ "]";
	}

}
