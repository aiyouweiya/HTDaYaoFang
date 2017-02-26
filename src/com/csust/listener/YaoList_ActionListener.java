package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.YaoList;

public class YaoList_ActionListener implements ActionListener{
	private YaoList yaoList;
	
	public YaoList_ActionListener(YaoList yaoList) {
		this.yaoList = yaoList;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("queren")){
			yaoList.btn_querenPerformed();
		}else if(command.equals("daochu")){
			yaoList.btn_daochuPerformed();
		}
	}
}
