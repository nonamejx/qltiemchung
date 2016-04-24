package com.qltiemchung.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.TinTuc;
import com.qltiemchung.model.bean.Vacxin;
import com.qltiemchung.model.bo.TinTucBO;
import com.qltiemchung.model.bo.VacxinBO;
import com.qltiemchung.utils.Validate;

/**
 * Servlet implementation class NguoiDungTimKiemVCServlet
 */
@WebServlet("/NguoiDungTimKiemVCServlet")
public class NguoiDungTimKiemVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDungTimKiemVCServlet() {
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
		
		// BO
		VacxinBO vacxinBO = new VacxinBO();
		TinTucBO tinTucBO = new TinTucBO();
		
		// object
		ArrayList<Vacxin> dsVacxin = null;
		ArrayList<TinTuc> dsTinTucGanDay = null;
		
		// lay danh sach tin tuc gan day
		dsTinTucGanDay = tinTucBO.getDsTinTuc(4, 10);
		request.setAttribute("dsTinTucGanDay", dsTinTucGanDay);
		
		// lay ds vac xin tim duoc
		String keyword = request.getParameter("keyword");
		if (keyword == null)
			keyword = "";
		
		// validate
		String error = "";
		boolean hasError = false;
		if ( !Validate.checkKeyword(keyword) && !"".equals(keyword.trim())) {
			error = "Từ khóa không hợp lệ\n";
			hasError = true;
		}
		if ( !Validate.checkString(keyword, 0, 100)) {
			error = "Số ký tự phải bé hơn 100\n";
			hasError = true;
		}
		
		if (hasError) {
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("user/tim-kiem-vc.jsp");
			rd.forward(request, response);
			return;
		}
		
		int page = 1;
		int recordsPerPage = 10;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		
		dsVacxin = vacxinBO.search(keyword, (page - 1) * recordsPerPage, recordsPerPage);
		int noOfRecords = vacxinBO.searchedResult(keyword);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("keyword", keyword);
        request.setAttribute("dsVacxin", dsVacxin);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
		request.setAttribute("sinhVienList", dsVacxin);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("user/tim-kiem-vc.jsp");
		rd.forward(request, response);
		
	}

}
