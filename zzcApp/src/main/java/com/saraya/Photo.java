package com.saraya;

import java.util.Date;

public class Photo {
	private int id;
	private String user;
	private String photoUrl;
	private String title;
	private Date targetDate;
	
	
	public Photo() {
		super();
	}


	public Photo(int id, String user, String photoUrl, String title, Date targetDate) {
		super();
		this.id = id;
		this.user = user;
		this.photoUrl = photoUrl;
		this.title = title;
		this.targetDate = targetDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Photo other = (Photo) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Photo [id=" + id + ", user=" + user + ", photoUrl=" + photoUrl + ", title=" + title + ", targetDate="
				+ targetDate + "]";
	}
	
	
	
	
	
	

	
	
}
