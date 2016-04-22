package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.LoaiTinTuc;
import com.qltiemchung.model.dao.LoaiTinTucDAO;

public class LoaiTinTucBO {
	private LoaiTinTucDAO dao = new LoaiTinTucDAO();
	
	public ArrayList<LoaiTinTuc> getTatCaLoaiTinTuc() {
		return dao.getTatCaLoaiTinTuc();
	}

	public LoaiTinTuc getLoaiTinTuc(int maTinTuc) {
		return dao.getLoaiTinTuc(maTinTuc);
	}

	public int addLoaiTinTuc(LoaiTinTuc loaiTin) {
		return dao.addLoaiTinTuc(loaiTin);
	}
	
	public int updateLoaiTinTuc(LoaiTinTuc loaiTin) {
		return dao.updateLoaiTinTuc(loaiTin);
	}
	
	public int deleteLoaiTinTuc(int maLoai) {
		return dao.deleteLoaiTinTuc(maLoai);
	}
}
