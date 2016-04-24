package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.CanBoBO;
import com.qltiemchung.model.bo.LoaiTinTucBO;
import com.qltiemchung.model.bo.TinTucBO;
import com.qltiemchung.utils.MyUtils;

/**
 * Servlet implementation class TinTucCapNhatServlet
 */
@WebServlet("/TinTucCapNhatServlet")
public class TinTucCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinTucCapNhatServlet() {
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
		boolean hasError = false;
		
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		String maTinTuc = (String) request.getParameter("matintuc");
		try {
			int ma = Integer.parseInt(maTinTuc);
			request.setAttribute("tintuc", new TinTucBO().getTinTuc(ma));
			request.setAttribute("DanhSachLoaiTinTuc", new LoaiTinTucBO().getTatCaLoaiTinTuc());
			request.setAttribute("DanhSachCanBo", new CanBoBO().getTatCaCanBo());
		} catch (Exception e) {
			// TODO: handle exception
			hasError = true;
		}
		
		MyUtils.putMessageBundle(request, bundle);
		if(hasError)
			response.sendRedirect(request.getContextPath()+"/TinTucDanhSachServlet");
		else MyUtils.forward(getServletContext(), request, response, "/admin/tin-tuc-cap-nhat.jsp");
	}

}
