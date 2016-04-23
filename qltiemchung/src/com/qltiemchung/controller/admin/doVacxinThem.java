package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bean.Vacxin;
import com.qltiemchung.model.bo.VacxinBO;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

@WebServlet("/doVacxinThem")
public class doVacxinThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doVacxinThem() {
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
		boolean hasError = false;
		Vacxin vacxin = null;
		VacxinBO vacxinBO = new VacxinBO();
		
		String tenVacxin = (String) request.getParameter("tenVacxin");
		String loaiVacxin = (String) request.getParameter("loaiVacxin");
		String tacDung = (String) request.getParameter("tacDung");
		String chiDinh = (String) request.getParameter("chiDinh");
		String chongChiDinh = (String) request.getParameter("chongChiDinh");
		String tacDungPhu = (String) request.getParameter("tacDungPhu");
		
		if(loaiVacxin.equals("select")){
			bundle.put("Vui lòng chọn loại vacxin",MessageState.FAIL);
			hasError = true;
		}
		if(!Validate.checkString(tenVacxin, 1, 100)){
			bundle.put("Tên vacxin không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		MyUtils.putMessageBundle(request, bundle);
		if (hasError) {
			vacxin = new Vacxin(tenVacxin, tacDung, chiDinh, chongChiDinh, tacDungPhu, -1);
			request.setAttribute("vacxin", vacxin);
			MyUtils.forward(getServletContext(), request, response, "/VacxinThemServlet");
			return;
		}
		
		vacxin = new Vacxin(tenVacxin, tacDung, chiDinh, chongChiDinh, tacDungPhu, Integer.parseInt(loaiVacxin));
		if (vacxinBO.addVacxin(vacxin) > 0) {
			// success
			bundle.put("Thêm thành công", MessageState.SUCCESS);
			
		} else {
			// failed
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		
		MyUtils.forward(getServletContext(), request, response, "/VacxinDanhSachServlet");
	}

}
