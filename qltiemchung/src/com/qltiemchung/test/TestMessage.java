package com.qltiemchung.test;

import com.qltiemchung.model.bean.Message;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;

public class TestMessage {

	public static void main(String[] args) {
		MessageBundle bundle = new MessageBundle();
		bundle.put("sai thong tin hoten", MessageState.FAIL);
		bundle.put("sai thong tin email", MessageState.FAIL);
		bundle.put("dang nhap thanh cong", MessageState.SUCCESS);
		
		for (Message m : bundle.getMessages()) {
			System.out.println(m);
		}
		
		bundle.getMessages(MessageState.SUCCESS).size();
	}

}
