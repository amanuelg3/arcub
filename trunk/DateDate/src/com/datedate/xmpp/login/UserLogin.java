package com.datedate.xmpp.login;

import org.jivesoftware.smack.XMPPConnection;


public class UserLogin {
	public String user;
	public String password;
	public String service;
	public String userid;
	
	public UserLogin(String uid, String pwd) {
		userid = uid;
		int idx = uid.indexOf("@");
		user = uid.substring(0, idx);
		service = uid.substring(idx + 1, uid.length());
		password = pwd;
	}
	
	public XMPPConnection connectServer() {
		//
		return null;
	}
	
	
}
