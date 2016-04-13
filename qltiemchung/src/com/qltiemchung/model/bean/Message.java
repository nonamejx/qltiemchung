package com.qltiemchung.model.bean;

import java.util.UUID;

public class Message {
	private UUID id;
	private String content;
	private MessageState state;

	public Message(String content, MessageState state) {
		this.id = UUID.randomUUID();
		this.content = content;
		this.state = state;
	}

	public UUID getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageState getState() {
		return state;
	}

	public void setState(MessageState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Message [" + content + ", " + state + "]";
	}

}
