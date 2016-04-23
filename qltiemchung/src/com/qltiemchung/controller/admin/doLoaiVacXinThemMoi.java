package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.KhachTiem;
import com.qltiemchung.model.bean.LoaiVacxin;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bo.KhachTiemBO;
import com.qltiemchung.model.bo.LoaiVacxinBO;
import com.qltiemchung.utils.DateUtils;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

@WebServlet("/doLoaiVacXinThemMoi")
@SuppressWarnings("all")
public class doLoaiVacXinThemMoi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private LoaiVacxinBO loaiVacxinBO = new LoaiVacxinBO();
	private LoaiVacxin loaiVacxin = null;

    public doLoaiVacXinThemMoi() {
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
		
		String tenLoai = request.getParameter("tenLoai");
		String moTa = request.getParameter("moTa");
		String ghiChu = request.getParameter("ghiChu");
		System.out.println(tenLoai);
		System.out.println(moTa);
		System.out.println(ghiChu);
		
		if (!Validate.checkString(tenLoai, 1, 100)) {
			bundle.put("Tên không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		if (hasError) {
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiVacXinThemMoiServlet");
			return;
		}
		
		loaiVacxin = new LoaiVacxin(tenLoai, moTa, ghiChu);
		if(loaiVacxinBO.addLoaiVacxin(loaiVacxin) > 0){
			bundle.put("Thêm mới thành công", MessageState.SUCCESS);
		}else{
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/LoaiVacxinDanhSachServlet");
	}
}
