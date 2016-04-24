package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.TinTuc;
import com.qltiemchung.model.dao.TinTucDAO;

public class TinTucBO {
	private TinTucDAO dao = new TinTucDAO();
	
	public ArrayList<TinTuc> getTatCaTinTuc() {
		return dao.getTatCaTinTuc();
	}
	
	public TinTuc getTinTuc(int maTinTuc) {
		return dao.getTinTuc(maTinTuc);
	}
	
	public int addTinTuc(TinTuc tt) {
		return dao.addTinTuc(tt);
	}
	
	public int updateTinTuc(TinTuc tt) {
		return dao.updateTinTuc(tt);
	}
	
	public int deleteTinTuc(int maTinTuc) {
		return dao.deleteTinTuc(maTinTuc);
	}
	
	// Kiet them 22/4 ----------
	
	// lay danh sach thong bao
	public ArrayList<TinTuc> getDsThongBao() {
		return dao.getDsThongBao();
	}
	
	// lay danh sach tin tuc
	public ArrayList<TinTuc> getDsTinTuc(int from, int to) {
		return dao.getDsTinTuc(from, to);
	}
	
	
}
