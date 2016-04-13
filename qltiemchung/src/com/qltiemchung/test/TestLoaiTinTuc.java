package com.qltiemchung.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.LoaiTinTuc;
import com.qltiemchung.model.dao.LoaiTinTucDAO;

public class TestLoaiTinTuc {

	public static void main(String[] args) throws SQLException {
		
		LoaiTinTucDAO dao = new LoaiTinTucDAO();
		
		// dao.addLoaiTinTuc(new LoaiTinTuc("loai tin 2", "Mo ta loai tin 2"));
		
		// dao.updateLoaiTinTuc(new LoaiTinTuc(2, "Loai tin 2", "Mo ta loai tin 2"));
		
		dao.deleteLoaiTinTuc(2);
		
		ArrayList<LoaiTinTuc> listLoaiTin = dao.getTatCaLoaiTinTuc();
		
		for (LoaiTinTuc loaiTinTuc : listLoaiTin) {
			System.out.println(loaiTinTuc);
		}
		
		// System.out.println(dao.getLoaiTinTuc(1));
	}

}
