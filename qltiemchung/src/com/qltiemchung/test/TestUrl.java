package com.qltiemchung.test;

import com.qltiemchung.model.bean.UrlCollection;
import com.qltiemchung.utils.UrlUtils;

public class TestUrl {

	public static void main(String[] args) {
		System.out.println(UrlCollection.TIN_TUC_DANH_SACH.getUrl());
		System.out.println(UrlUtils.getInstance(null).getPath(UrlCollection.TIN_TUC_DANH_SACH));
	}

}
