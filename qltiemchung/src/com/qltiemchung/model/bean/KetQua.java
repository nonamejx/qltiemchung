package com.qltiemchung.model.bean;

import java.sql.Timestamp;

public class KetQua {
	private int maKhach;
	private int maVacxin;
	private int maLich;
	private Timestamp ngayTiem;
	private String bacSi;
	private String diaDiem;
	private boolean trangThai;
	private String ghiChu;

	public KetQua(int maKhach, int maVacxin, int maLich, Timestamp ngayTiem,
			String bacSi, String diaDiem, boolean trangThai, String ghiChu) {
		this.maKhach = maKhach;
		this.maVacxin = maVacxin;
		this.maLich = maLich;
		this.ngayTiem = ngayTiem;
		this.bacSi = bacSi;
		this.diaDiem = diaDiem;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
	}

	public int getMaKhach() {
		return maKhach;
	}

	public void setMaKhach(int maKhach) {
		this.maKhach = maKhach;
	}

	public int getMaVacxin() {
		return maVacxin;
	}

	public void setMaVacxin(int maVacxin) {
		this.maVacxin = maVacxin;
	}

	public int getMaLich() {
		return maLich;
	}

	public void setMaLich(int maLich) {
		this.maLich = maLich;
	}

	public Timestamp getNgayTiem() {
		return ngayTiem;
	}

	public void setNgayTiem(Timestamp ngayTiem) {
		this.ngayTiem = ngayTiem;
	}

	public String getBacSi() {
		return bacSi;
	}

	public void setBacSi(String bacSi) {
		this.bacSi = bacSi;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "KetQua [" + maKhach + ", " + maVacxin + ", " + maLich + ", "
				+ ngayTiem + ", " + bacSi + ", " + diaDiem + ", " + trangThai
				+ ", " + ghiChu + "]";
	}

}
