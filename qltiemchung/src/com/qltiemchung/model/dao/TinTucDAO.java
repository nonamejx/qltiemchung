package com.qltiemchung.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.qltiemchung.model.bean.TinTuc;

public class TinTucDAO {
	private String sqlGetTatCaTinTuc = "SELECT maTin, maLoaiTin, ngayViet, ngayViet, tieuDe, noiDung FROM tintuc";
	private String sqlGetTinTucTheoMa = "SELECT maTin, maLoaiTin, ngayViet, ngayViet, tieuDe, noiDung FROM tintuc WHERE maTin = ?";
	private String sqlAddTinTuc = "INSERT INTO tintuc (maLoaiTin, nguoiViet, ngayViet, tieuDe, noiDung) VALUES (?, ?, ?, ?, ?)";
	private String sqlUpdateTinTuc = "UPDATE tintuc SET maLoaiTin = ?, ngayViet = ?, tieuDe = ?, noiDung = ? WHERE maTin = ?";
	private String sqlDeleteTinTuc = "DELETE FROM tintuc WHERE maTin = ?";
	private String sqlLayThongBao = "SELECT tintuc.maTin, tintuc.maLoaiTin, tintuc.nguoiViet, tintuc.ngayViet, tintuc.tieuDe, tintuc.noiDung"
			+ " FROM tintuc INNER JOIN loaitintuc ON tintuc.maLoaiTin = loaitintuc.maLoai"
			+ " WHERE loaitintuc.tenLoaiTin = ?"
			+ " ORDER BY tintuc.ngayViet DESC LIMIT 0,2";
	private String sqlLayDSTinTuc = "SELECT tintuc.maTin, tintuc.maLoaiTin, tintuc.nguoiViet, tintuc.ngayViet, tintuc.tieuDe, tintuc.noiDung"
			+ " FROM tintuc INNER JOIN loaitintuc ON tintuc.maLoaiTin = loaitintuc.maLoai"
			+ " WHERE loaitintuc.tenLoaiTin = ?"
			+ " ORDER BY tintuc.ngayViet DESC LIMIT ?,?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<TinTuc> dsTinTuc = null;
	private TinTuc tinTuc = null;
	
	public ArrayList<TinTuc> getTatCaTinTuc() {
		this.dsTinTuc = new ArrayList<TinTuc>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTatCaTinTuc);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this.tinTuc = new TinTuc(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6));
				this.dsTinTuc.add(this.tinTuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.dsTinTuc;
	}
	
	public TinTuc getTinTuc(int maTinTuc) {
		this.tinTuc = null;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGetTinTucTheoMa);
			
			pstmt.setInt(1, maTinTuc);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				this.tinTuc = new TinTuc(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return this.tinTuc;
	}
	
	public int addTinTuc(TinTuc tt) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlAddTinTuc);
			
			pstmt.setInt(1, tt.getMaLoaiTin());
			pstmt.setInt(2, tt.getMaNguoiViet());
			pstmt.setTimestamp(3, tt.getNgayViet());
			pstmt.setString(4, tt.getTieuDe());
			pstmt.setString(5, tt.getNoiDung());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int updateTinTuc(TinTuc tt) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlUpdateTinTuc);
			
			pstmt.setInt(1, tt.getMaLoaiTin());
			pstmt.setTimestamp(2, tt.getNgayViet());
			pstmt.setString(3, tt.getTieuDe());
			pstmt.setString(4, tt.getNoiDung());
			pstmt.setInt(5, tt.getMaTin());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	public int deleteTinTuc(int maTinTuc) {
		int result = 0;
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlDeleteTinTuc);
			
			pstmt.setInt(1, maTinTuc);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
		}
		
		return result;
	}
	
	// Lay thong bao
	public ArrayList<TinTuc> getDsThongBao() {
		ArrayList<TinTuc> dsThongBao = new ArrayList<TinTuc>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlLayThongBao);
			pstmt.setString(1, "Thông báo");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(5));
				tinTuc = new TinTuc(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6));
				dsThongBao.add(tinTuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return dsThongBao;
		
	}
	
	// lay danh sach tin tuc
	public ArrayList<TinTuc> getDsTinTuc(int from, int to) {
		dsTinTuc = new ArrayList<TinTuc>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlLayDSTinTuc);
			pstmt.setString(1, "Tin tức");
			pstmt.setInt(2, from);
			pstmt.setInt(3, to);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				tinTuc = new TinTuc(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6));
				dsTinTuc.add(tinTuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		
		return dsTinTuc;
	}
}
