package com.qltiemchung.model.bean;

public class LoaiVacxin {
	private int maLoai;
	private String tenLoai;
	private String moTa;
	private String ghiChu;

	public LoaiVacxin(int maLoai, String tenLoai, String moTa, String ghiChu) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
	}

	public LoaiVacxin(String tenLoai, String moTa, String ghiChu) {
		this.tenLoai = tenLoai;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getMaLoai() {
		return maLoai;
	}

	@Override
	public String toString() {
		return "LoaiVacxin [" + maLoai + ", " + tenLoai + ", " + moTa + ", "
				+ ghiChu + "]";
	}

}
