package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.LoaiTinTuc;

public class LoaiTinTucDAO {
	private String sqlGetTatCaLoaiTinTuc = "SELECT maLoai, tenLoaiTin, moTa FROM loaitintuc";
	private String sqlGetLoaiTinTucTheoMa = "SELECT maLoai, tenLoaiTin, moTa FROM loaitintuc WHERE maLoai = ?";
	private String sqlAddLoaiTinTuc = "INSERT INTO loaitintuc (tenLoaiTin, moTa) VALUES (?, ?)";
	private String sqlUpdateLoaiTinTuc = "UPDATE loaitintuc SET tenLoaiTin = ?, moTa = ? WHERE maLoai = ?";
	private String sqlDeleteLoaiTinTuc = "DELETE FROM loaitintuc WHERE maLoai = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<LoaiTinTuc> dsLoaiTinTuc = null;
	private LoaiTinTuc loaiTinTuc = null;

	public ArrayList<LoaiTinTuc> getTatCaLoaiTinTuc() {
		this.dsLoaiTinTuc = new ArrayList<LoaiTinTuc>();

		try {

			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaLoaiTinTuc);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				loaiTinTuc = new LoaiTinTuc(rs.getInt(1), rs.getString(2),
						rs.getString(3));
				dsLoaiTinTuc.add(loaiTinTuc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.dsLoaiTinTuc;
	}

	public LoaiTinTuc getLoaiTinTuc(int maTinTuc) {
		this.loaiTinTuc = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetLoaiTinTucTheoMa);

			pstmt.setInt(1, maTinTuc);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				this.loaiTinTuc = new LoaiTinTuc(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.loaiTinTuc;
	}

	public int addLoaiTinTuc(LoaiTinTuc loaiTin) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddLoaiTinTuc);
			
			pstmt.setString(1, loaiTin.getTenLoai());
			pstmt.setString(2, loaiTin.getMoTa());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		return result;
	}
	
	public int updateLoaiTinTuc(LoaiTinTuc loaiTin) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateLoaiTinTuc);
			
			pstmt.setString(1, loaiTin.getTenLoai());
			pstmt.setString(2, loaiTin.getMoTa());
			pstmt.setInt(3, loaiTin.getMaLoai());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		return result;
	}
	
	public int deleteLoaiTinTuc(int maLoai) {
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteLoaiTinTuc);
			
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
