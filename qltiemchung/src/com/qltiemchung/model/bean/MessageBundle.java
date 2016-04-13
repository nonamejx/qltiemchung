package com.qltiemchung.model.bean;

import java.util.ArrayList;

import com.qltiemchung.model.bean.Message;
import com.qltiemchung.model.bean.MessageState;

public class MessageBundle {

	private ArrayList<Message> messages;

	public MessageBundle() {
		this.messages = new ArrayList<Message>();
	}

	public void put(String content, MessageState state) {
		this.messages.add(new Message(content, state));
	}

	public ArrayList<Message> getMessages() {
		return this.messages;
	}

	public boolean isEmpty() {
		return this.messages.size() == 0;
	}

	public int count() {
		return this.messages.size();
	}

	public ArrayList<Message> getMessages(MessageState state) {
		ArrayList<Message> results = new ArrayList<Message>();
		for (Message m : this.messages) {
			if (m.getState() == state) {
				results.add(m);
			}
		}
		return results;
	}
	
	public void put(MessageBundle bundle) {
		if (bundle != null) 
			this.messages.addAll(bundle.getMessages());
	}

}
