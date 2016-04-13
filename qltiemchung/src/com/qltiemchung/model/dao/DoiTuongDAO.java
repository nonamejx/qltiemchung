package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.DoiTuong;

public class DoiTuongDAO {
	private String sqlGetTatCaDoiTuong = "SELECT maDoiTuong, tenDoiTuong, ghiChu, batDau, ketThuc FROM doituong";
	private String sqlGetDoiTuongTheoMa = "SELECT maDoiTuong, tenDoiTuong, ghiChu, batDau, ketThuc FROM doituong WHERE maDoiTuong = ?";
	private String sqlAddDoiTuong = "INSERT INTO doituong(tenDoiTuong, ghiChu, batDau, ketThuc) VALUES(?, ?, ?, ?)";
	private String sqlUpdateDoiTuong = "UPDATE doituong SET tenDoiTuong = ?, ghiChu = ?, batDau = ?, ketThuc = ? WHERE maDoiTuong = ?";
	private String sqlDeleteDoiTuong = "DELETE FROM doituong WHERE maDoiTuong = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<DoiTuong> dsDoiTuong = null;
	private DoiTuong doiTuong = null;
	
	public ArrayList<DoiTuong> getTatCaDoiTuong() {
		this.dsDoiTuong = new ArrayList<DoiTuong>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaDoiTuong);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.doiTuong = new DoiTuong(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				this.dsDoiTuong.add(this.doiTuong);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsDoiTuong;
	}
	
	public DoiTuong getDoiTuong(int maDoiTuong) {
		this.doiTuong = null;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetDoiTuongTheoMa);
			
			pstmt.setInt(1, maDoiTuong);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.doiTuong = new DoiTuong(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return this.doiTuong;
	}
	
	public int addDoiTuong(DoiTuong dt) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddDoiTuong);
			
			pstmt.setString(1, dt.getTenDoiTuong());
			pstmt.setString(2, dt.getGhiChu());
			pstmt.setInt(3, dt.getBatDau());
			pstmt.setInt(4, dt.getKetThuc());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		return result;
	}
	
	public int updateDoiTuong(DoiTuong dt) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateDoiTuong);
			
			pstmt.setString(1, dt.getTenDoiTuong());
			pstmt.setString(2, dt.getGhiChu());
			pstmt.setInt(3, dt.getBatDau());
			pstmt.setInt(4, dt.getKetThuc());
			pstmt.setInt(5, dt.getMaDoiTuong());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		return result;
	}
	
	public int deleteDoiTuong(int maDoiTuong) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteDoiTuong);
			
			pstmt.setInt(1, maDoiTuong);
			
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
