package com.qltiemchung.model.bo;

import java.util.ArrayList;

import com.qltiemchung.model.bean.Vacxin;
import com.qltiemchung.model.dao.VacxinDAO;

public class VacxinBO {
	private VacxinDAO dao = new VacxinDAO();
	
	public ArrayList<Vacxin> getTatCaVacxin() {
		return dao.getTatCaVacxin();
	}
	
	public Vacxin getVacxin(int maVacxin) {
		return dao.getVacxin(maVacxin);
	}
	
	public int addVacxin(Vacxin vc) {
		return dao.addVacxin(vc);
	}
	
	public int updateVacxin(Vacxin vc) {
		return dao.updateVacxin(vc);
	}
	
	public int deleteVacxin(int maVacxin) {
		return dao.deleteVacxin(maVacxin);
	}
	
}
