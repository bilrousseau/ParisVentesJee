package com.parisventes.helloworld.action;

import com.parisventes.helloworld.model.MessageStore;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	private static final long serialVersionUID = -1426967826890296347L;
	private MessageStore messageStore;
	private String userName;

    public int getCount() {
        return count;
    }

    private static int count = 0;
	

	public String execute() {
        this.messageStore = new MessageStore() ;
        if (userName != null) {
            this.messageStore.setMessage( messageStore.getMessage() + " " + userName);
            System.out.println(this.messageStore.getMessage());
        }
        HelloWorldAction.count++;
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}