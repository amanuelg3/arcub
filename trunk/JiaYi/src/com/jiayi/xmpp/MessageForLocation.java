package com.jiayi.xmpp;

public class MessageForLocation {
	String userid;
	long longitude, latitude, timestamp;
	public MessageForLocation(String uid, long lat, long lng, long tsp) {
		userid = uid;
		latitude = lat;
		longitude = lng;
		timestamp = tsp;
	}
}
