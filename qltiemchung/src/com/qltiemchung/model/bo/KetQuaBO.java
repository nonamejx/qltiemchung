package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.KetQua;
import com.qltiemchung.model.dao.KetQuaDAO;

public class KetQuaBO {
	private KetQuaDAO dao = new KetQuaDAO();
	
	public ArrayList<KetQua> getTatCaKetQua() {
		return dao.getTatCaKetQua();
	}
	
	public KetQua getKetQua(int maKhach, int maVacxin, int maLich) {
		return dao.getKetQua(maKhach, maVacxin, maLich);
	}
	
	public int addKetQua(KetQua kq) {
		return dao.addKetQua(kq);
	}
	
	public int deleteKetQua(int maKhach, int maVacxin, int maLich) {
		return dao.deleteKetQua(maKhach, maVacxin, maLich);
	}
	
}
