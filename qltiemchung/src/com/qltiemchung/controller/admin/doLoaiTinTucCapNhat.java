package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.LoaiTinTuc;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bo.LoaiTinTucBO;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

/**
 * Servlet implementation class doLoaiTinTucCapNhat
 */
@WebServlet("/doLoaiTinTucCapNhat")
public class doLoaiTinTucCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLoaiTinTucCapNhat() {
        super();
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
		LoaiTinTucBO loaiTinTucBO = new LoaiTinTucBO();
		LoaiTinTuc loaiTinTuc = null;
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		boolean hasError = false;
		
		String maLoai = request.getParameter("maLoai");
		String tenLoai = request.getParameter("tenLoai");
		String moTa = request.getParameter("moTa");
		
		
		
		if(!Validate.checkNumber(maLoai)){
			response.sendRedirect(getServletContext().getContextPath() + "/LoaiTinTucCapNhatServlet");
			return;
		}
		if(!Validate.checkString(tenLoai, 1, 100)){
			bundle.put("Tên loại tin tức không hợp lệ!", MessageState.FAIL);
			hasError = true;
		}
		if(!Validate.checkString(moTa, 1, 200)){
			bundle.put("Mã loại không hợp lệ!", MessageState.FAIL);
			hasError = true;
		}
		if(!Validate.checkString(moTa, 1, 200)){
			bundle.put("mô tả không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		
		
		if (hasError) {
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiTinTucCapNhatServlet");
			return;
		}
		
		loaiTinTuc = new LoaiTinTuc(Integer.parseInt(maLoai), tenLoai, moTa);
		
		
		
		if (loaiTinTucBO.updateLoaiTinTuc(loaiTinTuc) > 0) {
			
			bundle.put("Cập nhật thành công", MessageState.SUCCESS);
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiTinTucCapNhatServlet");
		} else {
			
			bundle.put("có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiTinTucCapNhatServlet");
		}
		
	}

}
