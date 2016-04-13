package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.LichTiemPhong;
import com.qltiemchung.model.dao.LichTiemPhongDAO;

public class LichTiemPhongBO {
	private LichTiemPhongDAO dao = new LichTiemPhongDAO();
	
	public ArrayList<LichTiemPhong> getTatCaLichTiem() {
		return dao.getTatCaLichTiem();
	}
	
	public LichTiemPhong getLichTiemPhong(int maLich) {
		return dao.getLichTiemPhong(maLich);
	}
	
	public int addLichTiem(LichTiemPhong lt) {
		return dao.addLichTiem(lt);
	}
	
	public int updateLichTiem(LichTiemPhong lt) {
		return dao.updateLichTiem(lt);
	}
	
	public int deleteLichTiem(int maLich) {
		return dao.deleteLichTiem(maLich);
	}
	
}
