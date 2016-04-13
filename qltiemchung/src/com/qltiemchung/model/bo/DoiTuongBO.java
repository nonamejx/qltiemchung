package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.DoiTuong;
import com.qltiemchung.model.dao.DoiTuongDAO;

public class DoiTuongBO {
	private DoiTuongDAO dao = new DoiTuongDAO();
	
	public ArrayList<DoiTuong> getTatCaDoiTuong() {
		return dao.getTatCaDoiTuong();
	}
	
	public DoiTuong getDoiTuong(int maDoiTuong) {
		return dao.getDoiTuong(maDoiTuong);
	}
	
	public int addDoiTuong(DoiTuong dt) {
		return dao.addDoiTuong(dt);
	}
	
	public int updateDoiTuong(DoiTuong dt) {
		return dao.updateDoiTuong(dt);
	}
	
	public int deleteDoiTuong(int maDoiTuong) {
		return dao.deleteDoiTuong(maDoiTuong);
	}
	
}
