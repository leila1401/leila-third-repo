package com.saraya.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.Photo;

@Service
public class PhotoService {
	private static List<Photo> photos = new ArrayList<>();
	private static int photoCount = 8;
	
	static {
		photos.add(new Photo(1,"Leila" , "https://images.unsplash.com/photo-1609075833548-f83d5d0d4ff6?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDR8aG1lbnZRaFVteE18fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Sun" , new Date()));
		photos.add(new Photo(2,"Leila" , "https://images.unsplash.com/photo-1609162347711-211c08bc7c0b?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDZ8aG1lbnZRaFVteE18fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Chateau" , new Date()));
		photos.add(new Photo(3,"Leila" , "https://images.unsplash.com/photo-1608803027005-4af1d976d002?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDV8aG1lbnZRaFVteE18fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "sea" , new Date()));
		photos.add(new Photo(4,"Leila" , "https://images.unsplash.com/photo-1609086476773-fb09bb9aca18?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDl8aG1lbnZRaFVteE18fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Tour" , new Date()));
		photos.add(new Photo(5,"Leila" , "https://images.unsplash.com/photo-1609075833548-f83d5d0d4ff6?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDR8aG1lbnZRaFVteE18fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "beautiful" , new Date()));
		photos.add(new Photo(6,"Leila" , "https://images.unsplash.com/photo-1608390451068-131784bb6220?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDI3fGhtZW52UWhVbXhNfHxlbnwwfHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Vintage" , new Date()));
		photos.add(new Photo(7,"Leila" , "https://images.unsplash.com/photo-1608229685889-a7f9f41ca333?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDI5fGhtZW52UWhVbXhNfHxlbnwwfHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Park" , new Date()));
		photos.add(new Photo(8,"Leila" , "https://images.unsplash.com/photo-1606873650325-b0db3fdc2c71?ixid=MXwxMjA3fDB8MHx0b3BpYy1mZWVkfDk2fGhtZW52UWhVbXhNfHxlbnwwfHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Car" , new Date()));

	}
	
	public List<Photo> retrievePhotos(String user){
		List<Photo> nicePhoto = new ArrayList<Photo>();
		for(Photo photo : photos) {
			if(photo.getUser().equals(user))
				nicePhoto.add(photo);
		}
		return nicePhoto;
	}
	
	public Photo retrievePhoto(int id) {
		for(Photo photo : photos) {
			if(photo.getId() == id)
				return photo;
		}
		return null;
	}
	public void UpDatePhoto(Photo photo) {
		photos.remove(photo);
		photos.add(photo);
	}
	
	public void addPhoto(String user , String photoUrl, String title , Date targetDate) {
		photos.add(new Photo(++photoCount , user , photoUrl , title, targetDate));
	}
	
	public void deletePhoto(int id) {
		Iterator<Photo> mady = photos.iterator();
		while(mady.hasNext()) {
			Photo photo = mady.next();
			if(photo.getId() == id) {
				mady.remove();
			}
		}
	}
	
	

}
