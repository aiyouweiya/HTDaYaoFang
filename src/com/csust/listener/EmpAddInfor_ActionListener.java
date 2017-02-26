package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.EmpAddInfor;

public class EmpAddInfor_ActionListener implements ActionListener{
	
	private EmpAddInfor empAddInfor;
	
	public EmpAddInfor_ActionListener(EmpAddInfor empAddInfor) {
		this.empAddInfor = empAddInfor;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("add")){
			empAddInfor.btn_AddPerformed();
		}else if(command.equals("clear")){
			empAddInfor.btn_ClearPerformed();
		}
	}
}
