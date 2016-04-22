package com.qltiemchung.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bean.TinTuc;
import com.qltiemchung.model.bo.TinTucBO;
import com.qltiemchung.utils.DateUtils;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

/**
 * Servlet implementation class doTinTucCapNhat
 */
@WebServlet("/doTinTucCapNhat")
public class doTinTucCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doTinTucCapNhat() {
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
		TinTuc tinTuc = null;
		TinTucBO tinTucBO = new TinTucBO();
		
		String maTinTuc = (String) request.getParameter("maTinTuc");
		String nguoiViet = (String) request.getParameter("nguoiViet");
		String ngayViet = (String) request.getParameter("ngayVietTin");
		String loaiTinTuc = (String) request.getParameter("loaiTinTuc");
		String tieuDe = (String) request.getParameter("tieuDe");
		String noiDung = (String) request.getParameter("noiDung");
		
		System.out.println("ngay viet"+ngayViet);
		Timestamp nv = Timestamp.valueOf(ngayViet);
		System.out.println(nv);
		
		if(!Validate.checkString(tieuDe, 1, 200)){
			bundle.put("Tiêu đề không hợp lệ",MessageState.FAIL);
			hasError = true;
		}
		if(!Validate.checkString(noiDung, 1, 1000)){
			bundle.put("Nội dung không hợp lệ",MessageState.FAIL);
			hasError = true;
		}
		
		MyUtils.putMessageBundle(request, bundle);
		if (hasError) {
			MyUtils.forward(getServletContext(), request, response, "/TinTucCapNhatServlet?matintuc="+maTinTuc);
			return;
		}
		
		tinTuc = new TinTuc(Integer.parseInt(maTinTuc), Integer.parseInt(loaiTinTuc), Integer.parseInt(nguoiViet), nv, tieuDe, noiDung);
		if (tinTucBO.updateTinTuc(tinTuc) > 0) {
			// success
			bundle.put("Cập nhật thành công", MessageState.SUCCESS);
			
		} else {
			// failed
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		
		MyUtils.forward(getServletContext(), request, response, "/TinTucDanhSachServlet");
	}

}
