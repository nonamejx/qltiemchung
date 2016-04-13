package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.LoaiVacxin;

public class LoaiVacxinDAO {
	private String sqlGetTatCaLoaiVacxin = "SELECT maLoai, tenLoai, moTa, ghiChu FROM loaivacxin";
	private String sqlGetLoaiVacxinTheoMa = "SELECT maLoai, tenLoai, moTa, ghiChu FROM loaivacxin WHERE maLoai = ?";
	private String sqlAddLoaiVacxin = "INSERT INTO loaivacxin(tenLoai, moTa, ghiChu) values(?, ?, ?)";
	private String sqlUpdateLoaiVacxin = "UPDATE loaivacxin SET tenLoai = ?, moTa = ?, ghiChu = ? WHERE maLoai = ?";
	private String sqlDeleteLoaiVacxin = "DELETE FROM loaivacxin WHERE maLoai = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<LoaiVacxin> dsLoaiVacxin = null;
	private LoaiVacxin loaiVacxin = null;
	
	public ArrayList<LoaiVacxin> getTatCaLoaiVacxin() {
		this.dsLoaiVacxin = new ArrayList<LoaiVacxin>();
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaLoaiVacxin);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.loaiVacxin = new LoaiVacxin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				this.dsLoaiVacxin.add(this.loaiVacxin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return this.dsLoaiVacxin;
	}
	
	public LoaiVacxin getLoaiVacxin(int maLoai) {
		this.loaiVacxin = null;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetLoaiVacxinTheoMa);
			
			pstmt.setInt(1, maLoai);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.loaiVacxin = new LoaiVacxin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return this.loaiVacxin;
	}
	
	public int addLoaiVacxin(LoaiVacxin lvc) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddLoaiVacxin);
			
			pstmt.setString(1, lvc.getTenLoai());
			pstmt.setString(2, lvc.getMoTa());
			pstmt.setString(3, lvc.getGhiChu());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		return result;
	}
	
	public int updateVacxin(LoaiVacxin lvc) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateLoaiVacxin);
			
			pstmt.setString(1, lvc.getTenLoai());
			pstmt.setString(2, lvc.getMoTa());
			pstmt.setString(3, lvc.getGhiChu());
			pstmt.setInt(4, lvc.getMaLoai());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		return result;
	}
	
	public int deleteVacxin(int maLoai) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteLoaiVacxin);
			
			pstmt.setInt(1, maLoai);
			
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
