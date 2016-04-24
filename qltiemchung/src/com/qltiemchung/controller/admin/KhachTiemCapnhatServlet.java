package com.qltiemchung.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.KhachTiem;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.KhachTiemBO;
import com.qltiemchung.utils.MyUtils;

@WebServlet("/KhachTiemCapNhatServlet")
@SuppressWarnings("all")
public class KhachTiemCapnhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachTiemBO khachTiemBO = new KhachTiemBO();
	private KhachTiem khachTiem = null;
       
    public KhachTiemCapnhatServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if(request.getParameter("makhach")!=null){
			int makhach = Integer.parseInt(request.getParameter("makhach"));
			khachTiem = khachTiemBO.getKhachTiem(makhach);
			request.setAttribute("khachTiem", khachTiem);
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/admin/khach-tiem-cap-nhat.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/KhachTiemDanhSachServlet");
		}
	}
}
