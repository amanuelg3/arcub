package com.jiayi.xmpp;

import java.util.Collection;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;

public class XMPPUtility {
	private XMPPConnection conn;
	public XMPPUtility(XMPPConnection con) {
		conn = con;
	}
	
	public boolean getAvailableUser(String user) {
		Roster roster = conn.getRoster();
		Collection<RosterEntry> entries = roster.getEntries();
		for (RosterEntry entry : entries) {
			if (entry.getUser().equals(user) && roster.getPresence(entry.getUser()).isAvailable())
				return true;
		}
		return false;
	}
	
	//public void 
	
}