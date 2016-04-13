package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.LoaiVacxin;
import com.qltiemchung.model.dao.LoaiVacxinDAO;

public class LoaiVacxinBO {
	private LoaiVacxinDAO dao = new LoaiVacxinDAO();
	
	public ArrayList<LoaiVacxin> getTatCaLoaiVacxin() {
		return dao.getTatCaLoaiVacxin();
	}
	
	public LoaiVacxin getLoaiVacxin(int maLoai) {
		return dao.getLoaiVacxin(maLoai);
	}
	
	public int addLoaiVacxin(LoaiVacxin lvc) {
		return dao.addLoaiVacxin(lvc);
	}
	
	public int updateVacxin(LoaiVacxin lvc) {
		return dao.updateVacxin(lvc);
	}
	
	public int deleteVacxin(int maLoai) {
		return dao.deleteVacxin(maLoai);
	}
	
}
