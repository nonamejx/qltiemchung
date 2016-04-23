package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.CanBo;
import com.qltiemchung.model.bean.LoaiTinTuc;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bo.LoaiTinTucBO;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

/**
 * Servlet implementation class doLoaiTinTucThem
 */
@WebServlet("/doLoaiTinTucThem")
public class doLoaiTinTucThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLoaiTinTucThem() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		
		
		LoaiTinTucBO loaiTinTucBO = new LoaiTinTucBO();
		LoaiTinTuc loaiTinTuc = null;
		boolean hasError = false;
		
		String tenLoai = request.getParameter("tenloai");
		String moTa = request.getParameter("mota");
		
		if (!Validate.checkString(tenLoai, 1, 100)) {
			bundle.put("Tên loại tin tức không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		if (!Validate.checkString(moTa, 1, 100)) {
			bundle.put("Mã loại không hợp lệ", MessageState.FAIL);
			hasError = true;
		}
		
		if(hasError){
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiTinTucThemServlet");
			return;
		}
		loaiTinTuc = new LoaiTinTuc(tenLoai, moTa);
		if (loaiTinTucBO.addLoaiTinTuc(loaiTinTuc) > 0) {
			// success
			bundle.put("Thêm thành công", MessageState.SUCCESS);
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiTinTucThemServlet");
		} else {
			// failed
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/LoaiTinTucThemServlet");
		}
		
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/admin/loai-tin-tuc-them.jsp");
	}

}
