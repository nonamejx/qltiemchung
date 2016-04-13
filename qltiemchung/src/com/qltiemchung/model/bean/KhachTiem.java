package com.qltiemchung.model.bean;

import java.sql.Date;

public class KhachTiem {
	private int maKhach;
	private String hoTen;
	private int gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String tenDangNhap;
	private String matKhau;
	private String cmnd;
	private String email;
	private String soDienThoai;

	public KhachTiem(int maKhach, String hoTen, int gioiTinh, Date ngaySinh,
			String diaChi, String tenDangNhap, String matKhau, String cmnd,
			String email, String soDienThoai) {
		this.maKhach = maKhach;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.cmnd = cmnd;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public KhachTiem(String hoTen, int gioiTinh, Date ngaySinh, String diaChi,
			String tenDangNhap, String matKhau, String cmnd, String email,
			String soDienThoai) {
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.cmnd = cmnd;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getMaKhach() {
		return maKhach;
	}

	@Override
	public String toString() {
		return "KhachTiem [" + maKhach + ", " + hoTen + ", " + gioiTinh + ", "
				+ ngaySinh + ", " + diaChi + ", " + tenDangNhap + ", "
				+ matKhau + ", " + cmnd + ", " + email + ", " + soDienThoai
				+ "]";
	}

}
