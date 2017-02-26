package com.csust.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.csust.db.DBUtils;
import com.csust.model.Yao;
import com.mysql.jdbc.PreparedStatement;

public class YaoDAOImpl implements YaoDAOInf{

	@Override
	public List<Yao> getAllYao() {
		List<Yao> list = new ArrayList<Yao>();
		Yao yao;
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		String sql = "select * from yao where isDelete = ?";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setInt(1, 1);
			rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					yao = new Yao();
					yao.setBianhao(rs.getString("bianhao"));
					yao.setName(rs.getString("name"));
					yao.setPifaPrice(rs.getDouble("pifaPrice"));
					yao.setRemainCount(rs.getInt("remainCount"));
					yao.setSellPrice(rs.getDouble("sellPrice"));
					yao.setType(rs.getString("type"));
					list.add(yao);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(rs, pStatement, connection);
		}
		return list;
	}

	@Override
	public boolean updateYao(String bianhao,int count) {
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		boolean rs = false;
		String sql = "update yao set remainCount = ? where bianhao= ?";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setInt(1, count);
			pStatement.setString(2, bianhao);
			int result = pStatement.executeUpdate();
			if(result!=0){
				rs = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return rs;
	}
	
	@Override
	public boolean updateYao(Yao yao,String old) {
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		boolean rs = false;
		String sql = "update yao set bianhao=? , name=? , type = ?, sellPrice=? ,pifaPrice=? where bianhao= ?";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, yao.getBianhao());
			pStatement.setString(2, yao.getName());
			pStatement.setString(3, yao.getType());
			pStatement.setString(4, String.valueOf(yao.getSellPrice()));
			pStatement.setString(5, String.valueOf(yao.getPifaPrice()));
			pStatement.setString(6, old);
//			System.out.println(sql);
			int result = pStatement.executeUpdate();
			if(result!=0){
				rs = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return rs;
	}
	
	

//	@Override
//	public boolean deleteYao(String bianhao) {
//		Connection connection = DBUtils.getConn();
//		PreparedStatement pStatement = null;
//		boolean rs = false;
//		String sql = "delete from yao where bianhao = ?";
//		try {
//			pStatement = (PreparedStatement) connection.prepareStatement(sql);
//			pStatement.setString(1, bianhao);
//			int result = pStatement.executeUpdate();
//			if(result!=0){
//				rs = true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtils.free(pStatement, connection);
//		}
//		return rs;
//	}
	
	
	@Override
	public boolean deleteYao(String bianhao) {
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		boolean rs = false;
		String sql = "update yao set isDelete = ? where bianhao = ?";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setInt(1, 0);
			pStatement.setString(2, bianhao);
			int result = pStatement.executeUpdate();
			if(result!=0){
				rs = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return rs;
	}

	@Override
	public boolean insertYao(Yao yao) {
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		boolean rs = false;
		String sql = "insert into yao values (?,?,?,?,?,?,1)";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, yao.getBianhao());
			pStatement.setString(2, yao.getName());
			pStatement.setString(3, yao.getType());
			pStatement.setString(4, String.valueOf(yao.getSellPrice()));
			pStatement.setString(5, String.valueOf(yao.getPifaPrice()));
			pStatement.setString(6, String.valueOf(yao.getRemainCount()));
			int result = pStatement.executeUpdate();
			if(result!=0){
				rs = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return rs;
	}

	@Override
	public String getYaoName(String rfid) {
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		String name = null;
		String sql = "select * from yao where bianhao = ?";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, rfid);
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()){
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
}
