package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.VacxinBO;
import com.qltiemchung.utils.MyUtils;

/**
 * Servlet implementation class doVacxinXoa
 */
@WebServlet("/doVacxinXoa")
public class doVacxinXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doVacxinXoa() {
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
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		
		String mavacxin = (String) request.getParameter("mavacxin");
		new VacxinBO().deleteVacxin(Integer.parseInt(mavacxin));
		
		// 
		MyUtils.putMessageBundle(request, bundle);
		response.sendRedirect(request.getContextPath()+"/VacxinDanhSachServlet");
	}

}
