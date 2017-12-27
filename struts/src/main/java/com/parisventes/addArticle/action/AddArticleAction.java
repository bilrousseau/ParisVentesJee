package com.parisventes.addArticle.action;

import java.io.File;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.beans.Articles;

public class AddArticleAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Articles articleBean;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private Map<String, Object> session;
	
	public String execute() {
		System.out.println("ARTICLE BEAN : " + this.getArticleBean());
		System.out.println("FILE UPLOAD : " + this.getFileUpload());
		this.getArticleBean().create();
		return SUCCESS;
	}
	
	public Articles getArticleBean() {
		return this.articleBean;
	}
	
	public void setArticleBean(Articles articleBean) {
		this.articleBean = articleBean;
	}
	
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
