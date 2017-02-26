package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.GarageManageFrame;

public class GarageManageFrame_ActionListener implements ActionListener{

	private GarageManageFrame garageManageFrame;
	
	public GarageManageFrame_ActionListener(GarageManageFrame garageManageFrame) {
		this.garageManageFrame = garageManageFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("update")){
			garageManageFrame.btn_updatePerformed();
		}else if(command.equals("delete")){
			garageManageFrame.btn_deletePerformed();
		}else if(command.equals("inGoods")){
			garageManageFrame.btn_inGoodPerformed();
		}else if(command.equals("daochu")){
			garageManageFrame.btn_daochuPerformed();
		}
	}

}
