package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.CanBo;
import com.qltiemchung.model.dao.CanBoDAO;

public class CanBoBO {
	
	private CanBoDAO dao = new CanBoDAO();
	
	public ArrayList<CanBo> getTatCaCanBo() {
		return dao.getTatCaCanBo();
	}

	public CanBo getCanBo(int maCanBo) {
		return dao.getCanBo(maCanBo);
	}

	public int addCanBo(CanBo cb) {
		return dao.addCanBo(cb);
	}

	public int updateCanBo(CanBo cb) {
		return dao.updateCanBo(cb);
	}

	public int deleteCanBo(int maCanBo) {
		return dao.deleteCanBo(maCanBo);
	}
	
	public CanBo checkLogin(String tenDangNhap, String matKhau) {
		return dao.getCanBo(tenDangNhap, matKhau);
	}
	
}
