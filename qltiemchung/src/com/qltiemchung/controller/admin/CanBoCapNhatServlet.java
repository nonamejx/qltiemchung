package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.CanBoBO;
import com.qltiemchung.utils.MyUtils;

/**
 * Servlet implementation class ThongTinCaNhanServlet
 */
@WebServlet("/CanBoCapNhatServlet")
public class CanBoCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CanBoCapNhatServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MessageBundle bundle = MyUtils.getMessageBundle(request);//tất cả các trang servlet đều có
		
		request.setAttribute("CanBo", new CanBoBO().getCanBo(1));
		
		// 
		MyUtils.putMessageBundle(request, bundle);//tất cả các trang servlet đều có
		MyUtils.forward(getServletContext(), request, response, "/admin/can-bo-cap-nhat.jsp");
	}

}
