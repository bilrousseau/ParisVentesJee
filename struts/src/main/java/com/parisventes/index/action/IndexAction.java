package com.parisventes.index.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.beans.Articles;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Articles> articleList;
	
	public String execute() {
		this.setArticleList(Articles.getAll());
		return SUCCESS;
	}

	public ArrayList<Articles> getArticleList() {
		return this.articleList;
	}
	
	public void addArticle(Articles article) {
		this.articleList.add(article);
	}
	
	public void removeArticle(Articles article) {
		this.articleList.remove(article);
	}
	
	public void setArticleList(ArrayList<Articles> articleList) {
		this.articleList = articleList;
	}
	
	
}
