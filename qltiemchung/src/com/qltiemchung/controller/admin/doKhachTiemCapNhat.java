package com.qltiemchung.controller.admin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.KhachTiem;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bo.KhachTiemBO;
import com.qltiemchung.utils.DateUtils;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

@WebServlet("/doKhachTiemCapNhat")
@SuppressWarnings("all")
public class doKhachTiemCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachTiemBO khachTiemBO = new KhachTiemBO();
	private KhachTiem khachTiem = null;
    public doKhachTiemCapNhat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		boolean hasError = false;
		
		String maKhach = request.getParameter("maKhach");
		String hoTen = request.getParameter("hoTen");
		int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
		String ngaySinh = request.getParameter("ngaySinh");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String cmnd = request.getParameter("cmnd");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");
		String diaChi = request.getParameter("diaChi");
		
		if (!Validate.checkNumber(maKhach)) {
			response.sendRedirect(getServletContext().getContextPath() + "/KhachTiemDanhSachServlet");
			return;
		}
		if (!Validate.checkString(hoTen, 1, 100)) {
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
		if (!Validate.checkEmail(email)) {
			bundle.put("Email không hợp lệ.", MessageState.FAIL);
			hasError = true;
		}
		if (hasError) {
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/KhachTiemCapNhatServlet?makhach="+maKhach);
			return;
		}
		khachTiem = new KhachTiem(Integer.parseInt(maKhach), hoTen,gioiTinh, DateUtils.convertToSDate(ngaySinh), diaChi, tenDangNhap, matKhau, cmnd, email, soDienThoai);
		if(khachTiemBO.updateKhachTiem(khachTiem) > 0){
			bundle.put("Cập nhật thành công", MessageState.SUCCESS);
		}else{
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/KhachTiemCapNhatServlet?makhach="+maKhach);
	}
}
