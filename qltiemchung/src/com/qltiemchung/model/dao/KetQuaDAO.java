package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.KetQua;

public class KetQuaDAO {
	private String sqlGetTatCaKetQua = "SELECT maKhach, maVacxin, maLich, ngayTiem, bacSi, diaDiem, trangThai, ghiChu FROM ketqua";
	private String sqlGetKetQuaTheoMa = "SELECT maKhach, maVacxin, maLich, ngayTiem, bacSi, diaDiem, trangThai, ghiChu FROM ketqua WHERE maKhach = ? and maVacxin = ? and maLich = ?";
	private String sqlAddKetQua = "INSERT INTO ketqua(maKhach, maVacxin, maLich, ngayTiem, bacSi, diaDiem, trangThai, ghiChu) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	// private String sqlUpdateKetQua = "";
	private String sqlDeleteKetQua = "DELETE FROM ketqua WHERE maKhach = ? and maVacxin = ? and maLich = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<KetQua> dsKetQua = null;
	private KetQua ketQua = null;
	
	public ArrayList<KetQua> getTatCaKetQua() {
		this.dsKetQua = new ArrayList<KetQua>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaKetQua);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.ketQua = new KetQua(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(8));
				this.dsKetQua.add(this.ketQua);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsKetQua;
	}
	
	public KetQua getKetQua(int maKhach, int maVacxin, int maLich) {
		this.ketQua = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetKetQuaTheoMa);
			
			pstmt.setInt(1, maKhach);
			pstmt.setInt(2, maVacxin);
			pstmt.setInt(3, maLich);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.ketQua = new KetQua(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.ketQua;
	}
	
	public int addKetQua(KetQua kq) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddKetQua);
			
			pstmt.setInt(1, kq.getMaKhach());
			pstmt.setInt(2, kq.getMaVacxin());
			pstmt.setInt(3, kq.getMaLich());
			pstmt.setTimestamp(4, kq.getNgayTiem());
			pstmt.setString(5, kq.getBacSi());
			pstmt.setString(6, kq.getDiaDiem());
			pstmt.setBoolean(7, kq.isTrangThai());
			pstmt.setString(8, kq.getGhiChu());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return result;
	}
	
	public int updateKetQua(KetQua kq) {
		int result = 0;
		
		return result;
	}
	
	public int deleteKetQua(int maKhach, int maVacxin, int maLich) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteKetQua);
			
			pstmt.setInt(1, maKhach);
			pstmt.setInt(2, maVacxin);
			pstmt.setInt(3, maLich);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return result;
	}
}
