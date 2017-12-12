package com.parisventes.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Articles {
	private Integer id;
	private String title;
	private String linkImg;
	private String description;
	private Float price;
	
	private Articles() {
		super();
	}

	public Articles(Integer id, String title, String linkImg, String description, Float price) {
		this();
		this.id = id;
		this.title = title;
		this.linkImg = linkImg;
		this.description = description;
		this.price = price;
	}
	
	public static ArrayList<Articles> getAll() {
		BufferedReader br;
		ArrayList<Articles> articleList = new ArrayList<Articles>();
		
		try {
			br = new BufferedReader(new FileReader(DB.FILENAME));
			
			while (br.ready()) {
				addToList(articleList, br.readLine().split(";"));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return articleList;
    }
	
    public static Articles getById(Integer id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(DB.FILENAME));
			
			while (br.ready()) {
				String[] lineArr = br.readLine().split(";");
				Integer tabId = 0;
				
				tabId = Integer.parseInt(lineArr[0]);
				if (tabId == id) {
					return new Articles(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], lineArr[3], Float.parseFloat(lineArr[4])); 
				}
				br.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
    // Modifier cette fonction lorsque la structure du fichier de données change
    private static void addToList(ArrayList<Articles> articleList, String[] lineArr) {
    	try {
        	Integer articleId = Integer.parseInt(lineArr[0]);
        	Float articlePrice = Float.parseFloat(lineArr[4]);
        	articleList.add(
        		new Articles(articleId, lineArr[1], lineArr[2], lineArr[3], articlePrice)
        	);
    	}
    	catch (NumberFormatException e) {
    		System.out.println(e.getMessage());
    	}	
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
	
	
	
}
