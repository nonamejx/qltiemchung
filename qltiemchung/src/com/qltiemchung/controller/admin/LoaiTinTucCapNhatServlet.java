package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.CanBoBO;
import com.qltiemchung.model.bo.LoaiTinTucBO;
import com.qltiemchung.utils.MyUtils;

/**
 * Servlet implementation class LoaiTinTucCapNhatServlet
 */
@WebServlet("/LoaiTinTucCapNhatServlet")
public class LoaiTinTucCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiTinTucCapNhatServlet() {
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
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		
		// ??
		// vi sao ko lay id truyen mà truyen qua 1 :)))
		String id = request.getParameter("maLoai");
		
		request.setAttribute("LoaiTinTuc", new LoaiTinTucBO().getLoaiTinTuc(Integer.parseInt(id)));
		
		
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/admin/loai-tin-tuc-cap-nhat.jsp");
	}

}
