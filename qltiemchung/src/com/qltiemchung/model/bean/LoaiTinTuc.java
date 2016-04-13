package com.qltiemchung.model.bean;

public class LoaiTinTuc {
	private int maLoai;
	private String tenLoai;
	private String moTa;

	public LoaiTinTuc(int maLoai, String tenLoai, String moTa) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

	public LoaiTinTuc(String tenLoai, String moTa) {
		this.tenLoai = tenLoai;
		this.moTa = moTa;
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

	public int getMaLoai() {
		return maLoai;
	}

	@Override
	public String toString() {
		return "LoaiTinTuc [" + maLoai + ", " + tenLoai + ", " + moTa + "]";
	}

}
