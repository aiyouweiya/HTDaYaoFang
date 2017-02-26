package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.UpdateGoodsDia;

public class UpdateGoodsDia_ActionListener implements ActionListener{

	private UpdateGoodsDia updateGoodsDia;
	
	public UpdateGoodsDia_ActionListener(UpdateGoodsDia updateGoodsDia) {
		this.updateGoodsDia = updateGoodsDia;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("yes")){
			updateGoodsDia.btn_YesPerformed();
		}else if(command.equals("clear")){
			updateGoodsDia.btn_ClearPerformed();
		}
	}

}
