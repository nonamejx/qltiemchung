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

/**
 * Servlet implementation class doVacxinCapNhat
 */
@WebServlet("/doVacxinCapNhat")
public class doVacxinCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doVacxinCapNhat() {
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
		
		String maVacxin = (String) request.getParameter("maVacxin");
		String tenVacxin = (String) request.getParameter("tenVacxin");
		String loaiVacxin = (String) request.getParameter("loaiVacxin");
		String tacDung = (String) request.getParameter("tacDung");
		String chiDinh = (String) request.getParameter("chiDinh");
		String chongChiDinh = (String) request.getParameter("chongChiDinh");
		String tacDungPhu = (String) request.getParameter("tacDungPhu");
		
		if(!Validate.checkString(tenVacxin, 1, 100)){
			bundle.put("Tên vacxin không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		
		MyUtils.putMessageBundle(request, bundle);
		if (hasError) {
			MyUtils.forward(getServletContext(), request, response, "/VacxinCapNhatServlet?mavacxin="+maVacxin);
			return;
		}
		
		vacxin = new Vacxin(Integer.parseInt(maVacxin), tenVacxin, tacDung, chiDinh, chongChiDinh, tacDungPhu, Integer.parseInt(loaiVacxin));
		if (vacxinBO.updateVacxin(vacxin) > 0) {
			// success
			bundle.put("Cập nhật thành công", MessageState.SUCCESS);
			
		} else {
			// failed
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		
		MyUtils.forward(getServletContext(), request, response, "/VacxinDanhSachServlet");
	}

}
