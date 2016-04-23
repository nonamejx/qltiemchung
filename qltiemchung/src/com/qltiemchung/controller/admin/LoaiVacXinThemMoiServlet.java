package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.utils.MyUtils;

@WebServlet("/LoaiVacXinThemMoiServlet")
@SuppressWarnings("all")
public class LoaiVacXinThemMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public LoaiVacXinThemMoiServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		MessageBundle bundle = MyUtils.getMessageBundle(request);
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/admin/loai-vac-xin-them-moi.jsp");
	}
}
