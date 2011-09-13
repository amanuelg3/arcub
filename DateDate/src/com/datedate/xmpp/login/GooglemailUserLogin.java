package com.datedate.xmpp.login;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;


import android.util.Log;

public class GooglemailUserLogin extends UserLogin{
	private XMPPConnection conn = null;
	private static String logtag = "GooglemailLogin";
	
	public GooglemailUserLogin(String uid, String pwd) {
		super(uid, pwd);
		// TODO Auto-generated constructor stub
	}
	
	public XMPPConnection connectServer() {
		ConnectionConfiguration cfg = new ConnectionConfiguration("talk.google.com", 5222, "googlemail.com");
		cfg.setSASLAuthenticationEnabled(false);
		conn = new XMPPConnection(cfg);
    	try {    		
			conn.connect();
			conn.login(super.user, super.password);
			Presence presence = new Presence(Presence.Type.available);
			presence.setStatus("UsingDateDate");
			conn.sendPacket(presence);			
		} catch (XMPPException e) {
			Log.v(logtag, "Error when login " + conn.getHost());
			e.printStackTrace();
			conn = null;
		}    	
		return conn;		
	}

}
