package com.qltiemchung.utils;

import javax.servlet.http.HttpServletRequest;

import com.qltiemchung.model.bean.UrlCollection;

public class UrlUtils {

	private HttpServletRequest request;

	private static UrlUtils instance;

	public static UrlUtils getInstance(HttpServletRequest request) {
		if (instance == null) {
			return new UrlUtils(request);
		}
		return instance;
	}

	private UrlUtils(HttpServletRequest request) {
		this.request = request;
	}

	public String getPath(UrlCollection urlCollection) {
		if (request == null) {
			return null;
		} else {
			return this.request.getContextPath().concat(urlCollection.getUrl());
		}

	}
}
