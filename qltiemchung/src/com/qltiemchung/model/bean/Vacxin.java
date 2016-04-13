package com.qltiemchung.model.bean;

public class Vacxin {
	private int maVacxin;
	private String tenVacxin;
	private String tacDung;
	private String chiDinh;
	private String chongChiDinh;
	private String tacDungPhu;
	private int maLoai;

	public Vacxin(int maVacxin, String tenVacxin, String tacDung,
			String chiDinh, String chongChiDinh, String tacDungPhu, int maLoai) {
		this.maVacxin = maVacxin;
		this.tenVacxin = tenVacxin;
		this.tacDung = tacDung;
		this.chiDinh = chiDinh;
		this.chongChiDinh = chongChiDinh;
		this.tacDungPhu = tacDungPhu;
		this.maLoai = maLoai;
	}

	public Vacxin(String tenVacxin, String tacDung, String chiDinh,
			String chongChiDinh, String tacDungPhu, int maLoai) {
		this.tenVacxin = tenVacxin;
		this.tacDung = tacDung;
		this.chiDinh = chiDinh;
		this.chongChiDinh = chongChiDinh;
		this.tacDungPhu = tacDungPhu;
		this.maLoai = maLoai;
	}

	public int getMaVacxin() {
		return maVacxin;
	}

	public void setMaVacxin(int maVacxin) {
		this.maVacxin = maVacxin;
	}

	public String getTenVacxin() {
		return tenVacxin;
	}

	public void setTenVacxin(String tenVacxin) {
		this.tenVacxin = tenVacxin;
	}

	public String getTacDung() {
		return tacDung;
	}

	public void setTacDung(String tacDung) {
		this.tacDung = tacDung;
	}

	public String getChiDinh() {
		return chiDinh;
	}

	public void setChiDinh(String chiDinh) {
		this.chiDinh = chiDinh;
	}

	public String getChongChiDinh() {
		return chongChiDinh;
	}

	public void setChongChiDinh(String chongChiDinh) {
		this.chongChiDinh = chongChiDinh;
	}

	public String getTacDungPhu() {
		return tacDungPhu;
	}

	public void setTacDungPhu(String tacDungPhu) {
		this.tacDungPhu = tacDungPhu;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	@Override
	public String toString() {
		return "Vacxin [" + maVacxin + ", " + tenVacxin + ", " + tacDung + ", "
				+ chiDinh + ", " + chongChiDinh + ", " + tacDungPhu + ", "
				+ maLoai + "]";
	}

}
