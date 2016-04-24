package com.qltiemchung.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.TinTuc;
import com.qltiemchung.model.bo.TinTucBO;

/**
 * Servlet implementation class TrangChuKhachServlet
 */
@WebServlet("/TrangChuKhachServlet")
public class TrangChuKhachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TrangChuKhachServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		// BO
		TinTucBO tinTucBO = new TinTucBO();
		
		// object
		ArrayList<TinTuc> dsThongBao = null;
		ArrayList<TinTuc> dsTinTucMoiNhat = null;
		ArrayList<TinTuc> dsTinTucGanDay = null;
		
		// lay danh sach thong bao
		dsThongBao = tinTucBO.getDsThongBao();
		request.setAttribute("dsThongBao", dsThongBao);
		
		// lay danh sach tin tuc
		dsTinTucMoiNhat = tinTucBO.getDsTinTuc(0, 4);
		dsTinTucGanDay = tinTucBO.getDsTinTuc(4, 10);
		request.setAttribute("dsTinTucMoiNhat", dsTinTucMoiNhat);
		request.setAttribute("dsTinTucGanDay", dsTinTucGanDay);
		
		RequestDispatcher rd = request.getRequestDispatcher("user/trang-chu-khach.jsp");
		rd.forward(request, response);
	}

}
