package com.parisventes.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Articles {
	private Integer id;
	private String title;
	private String linkImg;
	private String description;
	private Float price;
	
	public Articles() {
	}

	public Articles(Integer id, String title, String linkImg, String description, Float price) {
		this.id = id;
		this.title = title;
		this.linkImg = linkImg;
		this.description = description;
		this.price = price;
	}
	
	public static ArrayList<Articles> getAll() {
		return getAll(true);
	}
	
	public static ArrayList<Articles> getAll(Boolean order) {
		ArrayList<Articles> articleList = new ArrayList<Articles>();
		try {
			String query = "SELECT * FROM articles";
			ResultSet resultSet = DB.executeSelect(query);
			if (!order) {
				query += " ORDER BY art_id DESC;";
			}
			
			while (resultSet.next()) {
				Articles a = new Articles();
				a.fillFields(resultSet);
				articleList.add(a);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return articleList;
    }
	
    public static Articles getById(Integer id) {
    	try {
			ResultSet res = DB.executeSelect("SELECT * FROM articles WHERE art_id = "+DB.parseToSql(String.valueOf(id))+" ;");
			
			if (res.next()) {
				Articles a = new Articles();
				a.fillFields(res);
				return a;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	
    	return null;
	}
    
    public static void delete(Integer id) {
    	try {
			DB.executeDelete("DELETE FROM articles WHERE art_id = " + DB.parseToSql(String.valueOf(id)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public Integer create() {
		Integer linesInserted = 0;
		String query = "INSERT INTO articles (art_title, art_link_img, art_description, art_price) VALUES (";
		query += DB.parseToSql(this.getTitle()) + "," + DB.parseToSql(this.getLinkImg()) + "," + DB.parseToSql(this.getDescription()) + "," + this.getPrice() + ");";
		
		try {
			linesInserted = DB.executeInsert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return linesInserted;

	}
	
    private void fillFields(ResultSet resultSet) throws SQLException {
    	this.setId(resultSet.getInt("art_id"));
    	this.setLinkImg(resultSet.getString("art_link_img"));
		this.setDescription(resultSet.getString("art_description"));
		this.setTitle(resultSet.getString("art_title"));
		this.setPrice(resultSet.getFloat("art_price"));
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Articles [id=" + id + ", title=" + title + ", linkImg=" + linkImg + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	
	
}
