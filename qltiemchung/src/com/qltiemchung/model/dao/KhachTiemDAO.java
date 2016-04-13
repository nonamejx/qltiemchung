package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.KhachTiem;

public class KhachTiemDAO {
	private String sqlGetTatCaKhachTiem = "SELECT maKhach, hoTen, gioiTinh, ngaySinh, diaChi, tenDangNhap, matKhau, cmnd, email, soDienThoai FROM khachtiem";
	private String sqlGetKhachTiemTheoMa = "SELECT maKhach, hoTen, gioiTinh, ngaySinh, diaChi, tenDangNhap, matKhau, cmnd, email, soDienThoai FROM khachtiem WHERE maKhach = ?";
	private String sqlAddKhachTiem = "INSERT INTO khachtiem (hoTen, gioiTinh, ngaySinh, diaChi, tenDangNhap, matKhau, cmnd, email, soDienThoai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String sqlUpdateKhachTiem = "UPDATE khachtiem SET hoTen = ?, gioiTinh = ?, ngaySinh = ?, diaChi = ?, tenDangNhap = ?, matKhau = ?, cmnd = ?, email = ?, soDienThoai = ? WHERE maKhach = ?";
	private String sqlDeleteKhachTiem = "DELETE FROM khachtiem WHERE maKhach = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<KhachTiem> dsKhachTiem = null;
	private KhachTiem khachTiem = null;
	
	public ArrayList<KhachTiem> getTatCaKhachTiem() {
		this.dsKhachTiem = new ArrayList<KhachTiem>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaKhachTiem);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.khachTiem = new KhachTiem(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				this.dsKhachTiem.add(this.khachTiem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsKhachTiem;
	}
	
	public KhachTiem getKhachTiem(int maKhach) {
		this.khachTiem = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetKhachTiemTheoMa);
			
			pstmt.setInt(1, maKhach);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.khachTiem = new KhachTiem(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.khachTiem;
	}
	
	public int addKhachTiem(KhachTiem kt) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddKhachTiem);
			
			pstmt.setString(1, kt.getHoTen());
			pstmt.setInt(2, kt.getGioiTinh());
			pstmt.setDate(3, kt.getNgaySinh());
			pstmt.setString(4, kt.getDiaChi());
			pstmt.setString(5, kt.getTenDangNhap());
			pstmt.setString(6, kt.getMatKhau());
			pstmt.setString(7, kt.getCmnd());
			pstmt.setString(8, kt.getEmail());
			pstmt.setString(9, kt.getSoDienThoai());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int updateKhachTiem(KhachTiem kt) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateKhachTiem);
			
			pstmt.setString(1, kt.getHoTen());
			pstmt.setInt(2, kt.getGioiTinh());
			pstmt.setDate(3, kt.getNgaySinh());
			pstmt.setString(4, kt.getDiaChi());
			pstmt.setString(5, kt.getTenDangNhap());
			pstmt.setString(6, kt.getMatKhau());
			pstmt.setString(7, kt.getCmnd());
			pstmt.setString(8, kt.getEmail());
			pstmt.setString(9, kt.getSoDienThoai());
			pstmt.setInt(10, kt.getMaKhach());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int deleteKhachTiem(int maKhach) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteKhachTiem);
			
			pstmt.setInt(1,  maKhach);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
}
