package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qltiemchung.model.bean.Vacxin;

public class VacxinDAO {
	private String sqlGetTatCaVacxin = "SELECT maVacxin, tenVacxin, tacDung, chiDinh, chongChiDinh, tacDungPhu, maLoai FROM vacxin";
	private String sqlGetVacxinTheoMa = "SELECT maVacxin, tenVacxin, tacDung, chiDinh, chongChiDinh, tacDungPhu, maLoai FROM vacxin WHERE maVacxin = ?";
	private String sqlAddVacxin = "INSERT INTO vacxin (tenVacxin, tacDung, chiDinh, chongChiDinh, tacDungPhu, maLoai) VALUES (?, ?, ?, ?, ?, ?)";
	private String sqlUpdateVacxin = "UPDATE vacxin SET tenVacxin = ?, tacDung = ?, chiDinh = ?, chongChiDinh = ?, tacDungPhu = ?, maLoai = ? WHERE maVacxin = ?";
	private String sqlDeleteVacxin = "DELETE FROM vacxin WHERE maVacxin = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<Vacxin> dsVacxin = null;
	private Vacxin vacxin = null;
	
	public ArrayList<Vacxin> getTatCaVacxin() {
		this.dsVacxin = new ArrayList<Vacxin>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaVacxin);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.vacxin = new Vacxin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				this.dsVacxin.add(this.vacxin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsVacxin;
	}
	
	public Vacxin getVacxin(int maVacxin) {
		this.vacxin = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetVacxinTheoMa);
			
			pstmt.setInt(1, maVacxin);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.vacxin = new Vacxin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.vacxin;
	}
	
	public int addVacxin(Vacxin vc) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddVacxin);
			
			pstmt.setString(1, vc.getTenVacxin());
			pstmt.setString(2, vc.getTacDung());
			pstmt.setString(3, vc.getChiDinh());
			pstmt.setString(4, vc.getChongChiDinh());
			pstmt.setString(5, vc.getTacDungPhu());
			pstmt.setInt(6, vc.getMaLoai());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int updateVacxin(Vacxin vc) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateVacxin);
			
			pstmt.setString(1, vc.getTenVacxin());
			pstmt.setString(2, vc.getTacDung());
			pstmt.setString(3, vc.getChiDinh());
			pstmt.setString(4, vc.getChongChiDinh());
			pstmt.setString(5, vc.getTacDungPhu());
			pstmt.setInt(6, vc.getMaLoai());
			pstmt.setInt(7, vc.getMaVacxin());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int deleteVacxin(int maVacxin) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteVacxin);
			
			pstmt.setInt(1, maVacxin);
			
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
