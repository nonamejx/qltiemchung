package com.qltiemchung.model.bean;

import java.sql.Date;

import com.qltiemchung.utils.DateUtils;

public class CanBo {
	private int maCanBo;
	private String tenCanBo;
	private String tenDangNhap;
	private String matKhau;
	private int gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String diaChi;

	public CanBo(int maCanBo, String tenCanBo, String tenDangNhap,
			String matKhau, int gioiTinh, Date ngaySinh, String soDienThoai,
			String diaChi) {
		this.maCanBo = maCanBo;
		this.tenCanBo = tenCanBo;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public CanBo(String tenCanBo, String tenDangNhap, String matKhau,
			int gioiTinh, Date ngaySinh, String soDienThoai, String diaChi) {
		this.tenCanBo = tenCanBo;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public String getTenCanBo() {
		return tenCanBo;
	}

	public void setTenCanBo(String tenCanBo) {
		this.tenCanBo = tenCanBo;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public void setMaCanBo(int maCanBo) {
		this.maCanBo = maCanBo;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getMaCanBo() {
		return maCanBo;
	}
	
	public String getFormattedBirtday() {
		return DateUtils.formatDate(this.ngaySinh);
	}

	@Override
	public String toString() {
		return "CanBo [" + maCanBo + ", " + tenCanBo + ", " + tenDangNhap
				+ ", " + matKhau + ", " + gioiTinh + ", " + ngaySinh + ", "
				+ soDienThoai + ", " + diaChi + "]";
	}

}
