package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.LoginFrame;

public class LoginFrame_ActionListener implements ActionListener{

	private LoginFrame lf;
	
	public LoginFrame_ActionListener(LoginFrame lf) {
		this.lf = lf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")){
			lf.btnLogin_actionPerformed();			
		}else{
			lf.comBox_actionPerformed();
		}
	}

}
