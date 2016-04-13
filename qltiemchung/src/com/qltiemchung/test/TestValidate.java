package com.qltiemchung.test;

import com.qltiemchung.utils.Validate;

public class TestValidate {

	public static void main(String[] args) {
		
//		System.out.println(Validate.checkPhone("1234567"));
//		System.out.println(Validate.checkPhone("123456789"));
//		System.out.println(Validate.checkPhone("12345678901234"));
//		System.out.println(Validate.checkPhone("1234567dfs"));
		
		System.out.println(Validate.checkDate("-23/12/7773"));
		System.out.println(Validate.checkDate("13/12/1234"));
		System.out.println(Validate.checkDate("3-2/4567"));
		System.out.println(Validate.checkDate("3/12/1800"));
		System.out.println(Validate.checkDate("3/12/2030"));
		
		
	}

}
