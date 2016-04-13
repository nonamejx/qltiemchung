package com.qltiemchung.test;

import java.sql.Date;

import com.qltiemchung.model.bean.CanBo;
import com.qltiemchung.model.bo.CanBoBO;
import com.qltiemchung.utils.DateUtils;

public class TestCanBo {

	public static void main(String[] args) {
		CanBoBO bo = new CanBoBO();
		CanBo cb = new CanBo("Can bo 2", "user2", "123456", 3, DateUtils.convertToSDate("23/12/1994"), "1234567890", "dia chi 1");
		
		System.out.println(bo.addCanBo(cb));
	}

}
