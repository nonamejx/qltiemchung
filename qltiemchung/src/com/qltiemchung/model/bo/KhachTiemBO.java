package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.KhachTiem;
import com.qltiemchung.model.dao.KhachTiemDAO;

public class KhachTiemBO {
	private KhachTiemDAO dao = new KhachTiemDAO();
	
	public ArrayList<KhachTiem> getTatCaKhachTiem() {
		return dao.getTatCaKhachTiem();
	}
	
	public KhachTiem getKhachTiem(int maKhach) {
		return dao.getKhachTiem(maKhach);
	}
	
	public int addKhachTiem(KhachTiem kt) {
		return dao.addKhachTiem(kt);
	}
	
	public int updateKhachTiem(KhachTiem kt) {
		return dao.updateKhachTiem(kt);
	}
	
	public int deleteKhachTiem(int maKhach) {
		return dao.deleteKhachTiem(maKhach);
	}
}
