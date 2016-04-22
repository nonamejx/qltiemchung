package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.LoaiVacxinBO;
import com.qltiemchung.model.bo.VacxinBO;
import com.qltiemchung.utils.MyUtils;

/**
 * Servlet implementation class VacxinCapNhatServlet
 */
@WebServlet("/VacxinCapNhatServlet")
public class VacxinCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VacxinCapNhatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean hasError = false;
		
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		String maVacxin = (String) request.getParameter("mavacxin");
		try {
			int ma = Integer.parseInt(maVacxin);
			request.setAttribute("vacxin", new VacxinBO().getVacxin(ma));
			request.setAttribute("DanhSachLoaiVacxin", new LoaiVacxinBO().getTatCaLoaiVacxin());
		} catch (Exception e) {
			// TODO: handle exception
			hasError = true;
		}
		
		MyUtils.putMessageBundle(request, bundle);
		if(hasError)
			response.sendRedirect(request.getContextPath()+"/VacxinDanhSachServlet");
		else MyUtils.forward(getServletContext(), request, response, "/admin/vacxin-cap-nhat.jsp");
	}

}
