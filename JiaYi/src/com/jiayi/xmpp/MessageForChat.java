package com.jiayi.xmpp;

public class MessageForChat {
	public String sender, receiver, content;
	public long timestamp;
	
	public MessageForChat(String snd, String rcv, long tsp, String cnt) {
		sender = snd;
		receiver = rcv;
		content = cnt;
		timestamp = tsp;
	}
}
