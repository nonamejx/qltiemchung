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
 * Servlet implementation class VacxinDanhSachServlet
 */
@WebServlet("/VacxinDanhSachServlet")
public class VacxinDanhSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VacxinDanhSachServlet() {
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
		VacxinBO vacxinBO = new VacxinBO();
		boolean hasError = false;
		
		//lay danh sach vacxin hien thi khi chon combobox
		String loaiVacxin = (String)request.getParameter("maLoaiVacxin");
		try{
			int ma = Integer.parseInt(loaiVacxin);
			request.setAttribute("DanhSachVacxin", vacxinBO.getVacxinTheoMaLoaiVacxin(Integer.parseInt(loaiVacxin)));
			request.setAttribute("maLVX", loaiVacxin);
			System.out.println(ma);
		}catch(Exception e){
			hasError = true;
		}
		if(hasError)
			request.setAttribute("DanhSachVacxin", vacxinBO.getTatCaVacxin());

		//lay danh sach loai vacxin de hien thi trong combobox
		request.setAttribute("DanhSachLoaiVacxin", new LoaiVacxinBO().getTatCaLoaiVacxin());
		 
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/admin/vacxin-danh-sach.jsp");
	}

}
