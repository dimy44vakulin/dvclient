package com.dimonvideo.client.model;

public class Feed {
	//Data Variables
	private String imageUrl, title, text, date, razdel, category, headers, user, size;
	private int id, comments;

	//Getters and Setters
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		if (!imageUrl.startsWith("http")) {
			imageUrl = "https://dimonvideo.ru" + imageUrl;
		}
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public String getHeaders() {
		return headers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazdel() {
		return razdel;
	}

	public void setRazdel(String razdel) {
		this.razdel = razdel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}