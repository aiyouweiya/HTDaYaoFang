package com.csust.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csust.db.DBUtils;
import com.csust.model.Employee;

public class EmpDAOImpl implements EmpDAOInf {

	

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> list = new ArrayList<Employee>();
		Employee employee;
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		String sql = "select * from employee";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					employee = new Employee();
					employee.setJobID(rs.getString("jobID"));
					employee.setName(rs.getString("name"));
					employee.setPassword(rs.getString("password"));
					employee.setPosition(rs.getString("position"));
					list.add(employee);
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
	public boolean passIsValid(String jobID,String password) {
		Boolean bool=false;
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		ResultSet rs = null;
//		System.out.println(name+","+password);
		String sql = "select * from employee where JobID = ? ";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, jobID);
			rs = pStatement.executeQuery();
			String passFrom=null;
			while(rs.next()){
				passFrom = rs.getString("password");
			}
//			System.out.println(passFrom+" "+password);
			bool=(passFrom.equals(password)?true:false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return bool;
	}

	@Override
	public boolean insertEmp(Employee employee) {
		int result ;
		boolean insert=false;
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		String sql = "insert into employee values (?,?,?,?)";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(2, employee.getName());
			pStatement.setString(1, employee.getJobID());
			pStatement.setString(4, employee.getPosition());
			pStatement.setString(3, employee.getPassword());
			result = pStatement.executeUpdate();
			if(result!=0){
				insert = true;
			}
//			System.out.println("result"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return insert;
	}

	@Override
	public boolean deleteEmp(String jobID) {
		int result ;
		boolean delete=false;
		Connection connection = DBUtils.getConn();
		PreparedStatement pStatement = null;
		String sql = "delete from employee where jobID = ?";
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, jobID);
			result = pStatement.executeUpdate();
			if(result!=0){
				delete = true;
			}
//			System.out.println("result"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.free(pStatement, connection);
		}
		return delete;
	}

}
