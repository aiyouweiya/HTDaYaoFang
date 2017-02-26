package com.csust.dao;

import java.util.List;

import javax.swing.JTable;

import com.csust.model.Yao;

public interface YaoDAOInf {
	List<Yao> getAllYao();
	boolean updateYao(String old,int newCount);
	boolean updateYao(Yao yao,String old);
	boolean deleteYao(String bianhao);
	boolean insertYao(Yao yao);
	String getYaoName(String rfid);
}
