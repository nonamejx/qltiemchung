package com.qltiemchung.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.LoaiVacxin;
import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bo.KhachTiemBO;
import com.qltiemchung.model.bo.LoaiVacxinBO;
import com.qltiemchung.utils.MyUtils;

@WebServlet("/LoaiVacxinDanhSachServlet")
@SuppressWarnings("all")
public class LoaiVacxinDanhSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiVacxinBO  loaiVacxinBO = new LoaiVacxinBO();
	private ArrayList<LoaiVacxin> listLoaiVacXin = new ArrayList<LoaiVacxin>();
	
    public LoaiVacxinDanhSachServlet() {
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
		listLoaiVacXin = loaiVacxinBO.getTatCaLoaiVacxin();
		request.setAttribute("listLoaiVacXin", listLoaiVacXin);
		MyUtils.putMessageBundle(request, bundle);
		MyUtils.forward(getServletContext(), request, response, "/admin/loai-vac-xin-danh-sach.jsp");
	}
}
