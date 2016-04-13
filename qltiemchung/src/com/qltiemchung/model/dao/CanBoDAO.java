package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.CanBo;

public class CanBoDAO {
	private String sqlGetTatCaCanBo = "SELECT maCanBo, tenCanBo, tenDangNhap, matKhau, gioiTinh, ngaySinh, soDienThoai, diaChi FROM canbo";
	private String sqlGetCanBoTheoMa = "SELECT maCanBo, tenCanBo, tenDangNhap, matKhau, gioiTinh, ngaySinh, soDienThoai, diaChi FROM canbo WHERE maCanBo = ?";
	private String sqlAddCanBo = "INSERT INTO canbo(tenCanBo, tenDangNhap, matKhau, gioiTinh, ngaySinh, soDienThoai, diaChi) values(?, ?, ?, ?, ?, ?, ?)";
	private String sqlUpdateCanBo = "UPDATE canbo SET tenCanBo = ?, tenDangNhap = ?, matKhau = ?, gioiTinh = ?, ngaySinh = ?, soDienThoai = ?, diaChi = ? WHERE maCanBo = ?";
	private String sqlDeleteCanBo = "DELETE FROM canbo WHERE maCanBo = ?";
	private String sqlKTDangNhap = "SELECT tenCanBo, tenDangNhap, matKhau, gioiTinh, ngaySinh, soDienThoai, diaChi FROM canbo WHERE tenDangNhap = ? AND matKhau = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<CanBo> dsCanBo = null;
	private CanBo canBo = null;

	public ArrayList<CanBo> getTatCaCanBo() {
		this.dsCanBo = new ArrayList<CanBo>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaCanBo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.canBo = new CanBo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
				this.dsCanBo.add(this.canBo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsCanBo;
	}

	public CanBo getCanBo(int maCanBo) {
		this.canBo = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetCanBoTheoMa);
			
			pstmt.setInt(1, maCanBo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.canBo = new CanBo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.canBo;
	}
	
	public CanBo getCanBo(String tenDangNhap, String matKhau) {
		this.canBo = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlKTDangNhap);
			
			pstmt.setString(1, tenDangNhap);
			pstmt.setString(2, matKhau);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.canBo = new CanBo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.canBo;
	}

	public int addCanBo(CanBo cb) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddCanBo);
			
			pstmt.setString(1, cb.getTenCanBo());
			pstmt.setString(2, cb.getTenDangNhap());
			pstmt.setString(3, cb.getMatKhau());
			pstmt.setInt(4, cb.getGioiTinh());
			pstmt.setDate(5, cb.getNgaySinh());
			pstmt.setString(6, cb.getSoDienThoai());
			pstmt.setString(7, cb.getDiaChi());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}

	public int updateCanBo(CanBo cb) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateCanBo);
			
			pstmt.setString(1, cb.getTenCanBo());
			pstmt.setString(2, cb.getTenDangNhap());
			pstmt.setString(3, cb.getMatKhau());
			pstmt.setInt(4, cb.getGioiTinh());
			pstmt.setDate(5, cb.getNgaySinh());
			pstmt.setString(6, cb.getSoDienThoai());
			pstmt.setString(7, cb.getDiaChi());
			pstmt.setInt(8, cb.getMaCanBo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}

	public int deleteCanBo(int maCanBo) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteCanBo);
			
			pstmt.setInt(1, maCanBo);
			
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
