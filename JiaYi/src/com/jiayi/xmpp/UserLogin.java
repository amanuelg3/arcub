package com.jiayi.xmpp;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import android.util.Log;

public class UserLogin {
	public String user;
	public String password;
	public String service;
	public String userid;
	
	private XMPPConnection conn = null;
	private static String logtag = "JabberLogin";
	
	public UserLogin(String uid, String pwd) {
		if (uid.contains("@")) {
			userid = uid;
			int idx = uid.indexOf("@");
			user = uid.substring(0, idx);
			service = uid.substring(idx + 1, uid.length());
			password = pwd;
		} else {
			user = uid;
			password = pwd;
			service = "jabber.org";
			userid = user + "@" + service;
		}
	}
	
	public XMPPConnection connectServer() {
		ConnectionConfiguration cfg = new ConnectionConfiguration(service, 5222);
		cfg.setSASLAuthenticationEnabled(false);
		conn = new XMPPConnection(cfg);
    	try {
    		//SASLAuthentication.supportSASLMechanism("PLAIN", 0);
			conn.connect();
			conn.login(user, password);
			Thread.sleep(2000);
			Presence presence = new Presence(Presence.Type.available);
			presence.setStatus("JiaYi");
			conn.sendPacket(presence);			
		} catch (XMPPException e) {
			Log.v(logtag, "Error when login " + conn.getHost());
			e.printStackTrace();
			conn = null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return conn;	
	}
}
