package com.qltiemchung.model.bean;

public class LichTiemPhong {
	private int maLich;
	private int maDoiTuong;
	private int maLoaiVacxin;
	private int lanTiem;
	private String ghiChu;

	public LichTiemPhong(int maDoiTuong, int maLoaiVacxin, int lanTiem,
			String ghiChu) {
		this.maDoiTuong = maDoiTuong;
		this.maLoaiVacxin = maLoaiVacxin;
		this.lanTiem = lanTiem;
		this.ghiChu = ghiChu;
	}

	public LichTiemPhong(int maLich, int maDoiTuong, int maLoaiVacxin,
			int lanTiem, String ghiChu) {
		this.maLich = maLich;
		this.maDoiTuong = maDoiTuong;
		this.maLoaiVacxin = maLoaiVacxin;
		this.lanTiem = lanTiem;
		this.ghiChu = ghiChu;
	}

	public int getMaLich() {
		return maLich;
	}

	public void setMaLich(int maLich) {
		this.maLich = maLich;
	}

	public int getMaDoiTuong() {
		return maDoiTuong;
	}

	public void setMaDoiTuong(int maDoiTuong) {
		this.maDoiTuong = maDoiTuong;
	}

	public int getMaLoaiVacxin() {
		return maLoaiVacxin;
	}

	public void setMaLoaiVacxin(int maLoaiVacxin) {
		this.maLoaiVacxin = maLoaiVacxin;
	}

	public int getLanTiem() {
		return lanTiem;
	}

	public void setLanTiem(int lanTiem) {
		this.lanTiem = lanTiem;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "LichTiemPhong [" + maLich + ", " + maDoiTuong + ", "
				+ maLoaiVacxin + ", " + lanTiem + ", " + ghiChu + "]";
	}

}
