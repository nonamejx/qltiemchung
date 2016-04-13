package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.LichTiemPhong;

public class LichTiemPhongDAO {
	private String sqlGetTatCaLichTiem = "SELECT maLich, maDoiTuong, maLoaiVacxin, lanTiem, ghiChu FROM lichtiemphong";
	private String sqlGetLichTiemTheoMa = "SELECT maLich, maDoiTuong, maLoaiVacxin, lanTiem, ghiChu FROM lichtiemphong WHERE maLich = ?";
	private String sqlAddLichTiem = "INSERT INTO lichtiemphong (maDoiTuong, maLoaiVacxin, lanTiem, ghiChu) VALUES (?, ?, ?, ?)";
	private String sqlUpdateLichTiem = "UPDATE lichtiemphong SET maDoiTuong = ?, maLoaiVacxin = ?, lanTiem = ?, ghiChu = ? WHERE maLich = ?";
	private String sqlDeleteLichTiem = "DELETE FROM lichtiemphong WHERE maLich = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<LichTiemPhong> dsLichTiem = null;
	private LichTiemPhong lichTiem = null;
	
	public ArrayList<LichTiemPhong> getTatCaLichTiem() {
		this.dsLichTiem = new ArrayList<LichTiemPhong>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaLichTiem);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.lichTiem = new LichTiemPhong(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				this.dsLichTiem.add(this.lichTiem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsLichTiem;
	}
	
	public LichTiemPhong getLichTiemPhong(int maLich) {
		this.lichTiem = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetLichTiemTheoMa);
			
			pstmt.setInt(1, maLich);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.lichTiem = new LichTiemPhong(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.lichTiem;
	}
	
	public int addLichTiem(LichTiemPhong lt) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddLichTiem);
			
			pstmt.setInt(1, lt.getMaDoiTuong());
			pstmt.setInt(2, lt.getMaLoaiVacxin());
			pstmt.setInt(3, lt.getLanTiem());
			pstmt.setString(4, lt.getGhiChu());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int updateLichTiem(LichTiemPhong lt) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateLichTiem);
			
			pstmt.setInt(1, lt.getMaDoiTuong());
			pstmt.setInt(2, lt.getMaLoaiVacxin());
			pstmt.setInt(3, lt.getLanTiem());
			pstmt.setString(4, lt.getGhiChu());
			pstmt.setInt(5, lt.getMaLich());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int deleteLichTiem(int maLich) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteLichTiem);
			
			pstmt.setInt(1, maLich);
			
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
