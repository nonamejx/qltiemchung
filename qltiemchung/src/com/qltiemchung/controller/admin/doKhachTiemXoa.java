package com.qltiemchung.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;
import com.qltiemchung.model.bean.MessageState;
import com.qltiemchung.model.bo.KhachTiemBO;
import com.qltiemchung.utils.MyUtils;

@WebServlet("/XoaThongTinServlet")
@SuppressWarnings("all")
public class doKhachTiemXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KhachTiemBO khachTiemBO = new KhachTiemBO();
    public doKhachTiemXoa() {
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
			int maKhach = Integer.parseInt(request.getParameter("makhach"));
			if(khachTiemBO.deleteKhachTiem(maKhach)>0){
				bundle.put("Xóa thành công", MessageState.SUCCESS);
			}else{
				bundle.put("Xóa thất bại", MessageState.FAIL);
			}
			MyUtils.putMessageBundle(request, bundle);
			MyUtils.forward(getServletContext(), request, response, "/KhachTiemDanhSachServlet");
	}
}
