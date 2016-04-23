package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.LoaiTinTucBO;
import com.qltiemchung.utils.MyUtils;

/**
 * Servlet implementation class doLoaiTinTucXoa
 */
@WebServlet("/doLoaiTinTucXoa")
public class doLoaiTinTucXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLoaiTinTucXoa() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		
		LoaiTinTucBO loaiTinTucBO = new LoaiTinTucBO();
		
		String id = request.getParameter("maLoai");
		loaiTinTucBO.deleteLoaiTinTuc(Integer.parseInt(id));
		
		MyUtils.putMessageBundle(request, bundle);
		response.sendRedirect(request.getContextPath() + "/LoaiTinTucDanhSachServlet");
	}

}
