package com.parisventes.index.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.beans.Articles;

public class IndexAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private ArrayList<Articles> articleList;
	private Articles testArticle;
	private Map<String, Object> session;
	
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

	public Articles getTestArticle() {
		return testArticle;
	}

	public void setTestArticle(Articles testArticle) {
		this.testArticle = testArticle;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
	
}
