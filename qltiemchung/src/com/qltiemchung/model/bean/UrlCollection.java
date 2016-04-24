package com.qltiemchung.model.bean;

public enum UrlCollection {
	TIN_TUC_DANH_SACH("/TinTucDanhSachServlet"),
	TIN_TUC_CAP_NHAT("/TinTucCapNhatServlet"),
	TIN_TUC_THEM_MOI("/TinTucThemServlet"),
	
	LOAI_TIN_TUC_DANH_SACH("/LoaiTinTucDanhSachServlet"),
	LOAI_TIN_TUC_CAP_NHAT("/LoaiTinTucCapNhatServlet"),
	LOAI_TIN_TUC_THEM_MOI("/LoaiTinTucThemServlet"),
	
	VACXIN_DANH_SACH("/VacxinDanhSachServlet"),
	VACXIN_CAP_NHAT("/VacxinCapNhatServlet"),
	VACXIN_THEM_MOI("/VacxinThemServlet"),
	
	LOAI_VACXIN_DANH_SACH("/LoaiVacxinDanhSachServlet"),
	LOAI_VACXIN_CAP_NHAT("/LoaiVacXinCapNhatServlet"),
	LOAI_VACXIN_THEM_MOI("/LoaiVacXinThemMoiServlet"),
	
	CAN_BO_DANH_SACH("/CanBoDanhSachServlet"),
	CAN_BO_CAP_NHAT("/CanBoCapNhatServlet"),
	CAN_BO_THEM_MOI("/CanBoThemServlet"),
	
	KHACH_TIEM_DANH_SACH("/KhachTiemDanhSachServlet"),
	KHACH_TIEM_CAP_NHAT("/KhachTiemCapnhatServlet"),
	KHACH_TIEM_THEM_MOI("/KhachTiemThemMoiServlet");

	private final String url;

	UrlCollection(final String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

}
