package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.CanBo;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bo.CanBoBO;
import com.qltiemchung.utils.DateUtils;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

/**
 * Servlet implementation class doCapNhatThongTinCaNhan
 */
@WebServlet("/doCanBoCapNhat")
public class doCanBoCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doCanBoCapNhat() {
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
		
		// Prepare BO, Objects, Message
		CanBoBO canBoBO = new CanBoBO();
		CanBo canBo = null;
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		boolean hasError = false;
		
		// get parameters
		String id = request.getParameter("id");
		String ten = request.getParameter("ten");
		String ngaySinh = request.getParameter("ngaySinh");
		String gioiTinh = request.getParameter("gioiTinh");
		String soDienThoai = request.getParameter("soDienThoai");
		String diaChi = request.getParameter("diaChi");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		
		// validate data
		if (!Validate.checkNumber(id)) {
			response.sendRedirect(getServletContext().getContextPath() + "/CanBoCapNhatServlet");
			return;
		}
		if (!Validate.checkString(ten, 1, 100)) {
			bundle.put("Tên không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		if (!Validate.checkDate(ngaySinh)) {
			bundle.put("Ngày sinh không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		if (!Validate.checkPhone(soDienThoai)) {
			bundle.put("Số điện thoại không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		if (!Validate.checkString(diaChi, 1, 200)) {
			bundle.put("Địa chỉ không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		
		// if error, return
		if (hasError) {
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/CanBoCapNhatServlet");
			return;
		}
		
		// can bo
		canBo = new CanBo(Integer.parseInt(id) ,ten, tenDangNhap, matKhau, Integer.parseInt(gioiTinh), DateUtils.convertToSDate(ngaySinh), soDienThoai, diaChi);
		
		// update information
		if (canBoBO.updateCanBo(canBo) > 0) {
			// success
			bundle.put("Cập nhật thành công", MessageState.SUCCESS);
			
		} else {
			// failed
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/CanBoCapNhatServlet");
	}

}
