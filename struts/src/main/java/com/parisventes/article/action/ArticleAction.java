package com.parisventes.article.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.beans.Articles;

public class ArticleAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private Articles articleBean;
	private Integer id;
	// L'id est récupéré depuis l'url : voir dans struts.xml pour comment faire
	
	public String execute() {
		this.setArticleBean(Articles.getById(this.getId()));
		return SUCCESS;
	}
	
	public String delete() {
		Articles.delete(this.getId());
		return SUCCESS;
	}
	
	public Articles getArticleBean() {
		return articleBean;
	}
	public void setArticleBean(Articles articleBean) {
		this.articleBean = articleBean;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
