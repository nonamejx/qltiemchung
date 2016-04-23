package com.qltiemchung.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bean.TinTuc;
import com.qltiemchung.model.bo.TinTucBO;
import com.qltiemchung.utils.MyUtils;
import com.qltiemchung.utils.Validate;

/**
 * Servlet implementation class doTinTucThem
 */
@WebServlet("/doTinTucThem")
public class doTinTucThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doTinTucThem() {
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
		
		String loaiTinTuc = (String) request.getParameter("loaiTinTuc");
		String tieuDe = (String) request.getParameter("tieuDe");
		String noiDung = (String) request.getParameter("noiDung");
		
		if(loaiTinTuc.equals("select")){
			bundle.put("Vui lòng chọn loại tin tức",MessageState.FAIL);
			hasError = true;
		}
		if(!Validate.checkString(tieuDe, 1, 200)){
			bundle.put("Tiêu đề không hợp lệ",MessageState.FAIL);
			hasError = true;
		}
		if(!Validate.checkString(noiDung, 1, 1000)){
			bundle.put("Nội dung không hợp lệ",MessageState.FAIL);
			hasError = true;
		}
		MyUtils.putMessageBundle(request, bundle);
		Date date = new Date();
		Timestamp ngayViet = new Timestamp((long)date.getTime());
		if (hasError) {
			tinTuc = new TinTuc(-1, 1, ngayViet, tieuDe, noiDung);
			request.setAttribute("tintuc", tinTuc);
			MyUtils.forward(getServletContext(), request, response, "/TinTucThemServlet");
			return;
		}
		
		tinTuc = new TinTuc(Integer.parseInt(loaiTinTuc), 1, ngayViet, tieuDe, noiDung);
		if (tinTucBO.addTinTuc(tinTuc) > 0) {
			// success
			bundle.put("Thêm thành công", MessageState.SUCCESS);
			
		} else {
			// failed
			bundle.put("Có lỗi về dữ liệu, xin thử lại", MessageState.FAIL);
		}
		
		MyUtils.forward(getServletContext(), request, response, "/TinTucDanhSachServlet");
	}

}
