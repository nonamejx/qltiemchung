package com.qltiemchung.model.bean;

public class DoiTuong {
	private int maDoiTuong;
	private String tenDoiTuong;
	private String ghiChu;
	private int batDau;
	private int ketThuc;

	public DoiTuong(String tenDoiTuong, String ghiChu, int batDau, int ketThuc) {
		this.tenDoiTuong = tenDoiTuong;
		this.ghiChu = ghiChu;
		this.batDau = batDau;
		this.ketThuc = ketThuc;
	}

	public DoiTuong(int maDoiTuong, String tenDoiTuong, String ghiChu,
			int batDau, int ketThuc) {
		this.maDoiTuong = maDoiTuong;
		this.tenDoiTuong = tenDoiTuong;
		this.ghiChu = ghiChu;
		this.batDau = batDau;
		this.ketThuc = ketThuc;
	}

	public String getTenDoiTuong() {
		return tenDoiTuong;
	}

	public void setTenDoiTuong(String tenDoiTuong) {
		this.tenDoiTuong = tenDoiTuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getBatDau() {
		return batDau;
	}

	public void setBatDau(int batDau) {
		this.batDau = batDau;
	}

	public int getKetThuc() {
		return ketThuc;
	}

	public void setKetThuc(int ketThuc) {
		this.ketThuc = ketThuc;
	}

	public int getMaDoiTuong() {
		return maDoiTuong;
	}

	@Override
	public String toString() {
		return "DoiTuong [" + maDoiTuong + ", " + tenDoiTuong + ", " + ghiChu
				+ ", " + batDau + ", " + ketThuc + "]";
	}

}
