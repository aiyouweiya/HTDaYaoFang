package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.InGoodsInfor;

public class InGoodsListener implements ActionListener {

	private InGoodsInfor infor;
	
	public InGoodsListener(InGoodsInfor infor) {
		this.infor = infor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("chaxun")){
			infor.btn_RequestPerformed();
		}else if(command.equals("in")){
			infor.btn_InPerformed();
		}else if(command.equals("queren")){
			infor.btn_YesPerformed();
		}else if(command.equals("qingkong")){
			infor.btn_ClearPerformed();
		}
	}

}
