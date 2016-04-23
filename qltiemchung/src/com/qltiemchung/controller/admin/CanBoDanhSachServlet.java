package com.qltiemchung.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.CanBo;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.model.bo.CanBoBO;




/**
 * Servlet implementation class CanBoThemServlet
 */
@WebServlet("/CanBoDanhSachServlet")
public class CanBoDanhSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public CanBoDanhSachServlet() {
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
		ArrayList<CanBo> arCanBo = new ArrayList<CanBo>();
		
		CanBoBO canboBO = new CanBoBO();
		arCanBo = canboBO.getTatCaCanBo();
		request.setAttribute("DanhSachCanBo", arCanBo);
		
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/admin/danh-sach-can-bo.jsp");
	}

}
