package com.qltiemchung.model.bean;

import java.sql.Timestamp;

public class TinTuc {
	private int maTin;
	private int maLoaiTin;
	private int maNguoiViet;
	private Timestamp ngayViet;
	private String tieuDe;
	private String noiDung;

	public TinTuc(int maTin, int maLoaiTin, int maNguoiViet,
			Timestamp ngayViet, String tieuDe, String noiDung) {
		this.maTin = maTin;
		this.maLoaiTin = maLoaiTin;
		this.maNguoiViet = maNguoiViet;
		this.ngayViet = ngayViet;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
	}

	public TinTuc(int maLoaiTin, int maNguoiViet, Timestamp ngayViet,
			String tieuDe, String noiDung) {
		super();
		this.maLoaiTin = maLoaiTin;
		this.maNguoiViet = maNguoiViet;
		this.ngayViet = ngayViet;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
	}

	public int getMaLoaiTin() {
		return maLoaiTin;
	}

	public void setMaLoaiTin(int maLoaiTin) {
		this.maLoaiTin = maLoaiTin;
	}

	public int getMaNguoiViet() {
		return maNguoiViet;
	}

	public void setMaNguoiViet(int maNguoiViet) {
		this.maNguoiViet = maNguoiViet;
	}

	public Timestamp getNgayViet() {
		return ngayViet;
	}

	public void setNgayViet(Timestamp ngayViet) {
		this.ngayViet = ngayViet;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getMaTin() {
		return maTin;
	}

	@Override
	public String toString() {
		return "TinTuc [" + maTin + ", " + maLoaiTin + ", " + maNguoiViet
				+ ", " + ngayViet + ", " + tieuDe + ", " + noiDung + "]";
	}

}
