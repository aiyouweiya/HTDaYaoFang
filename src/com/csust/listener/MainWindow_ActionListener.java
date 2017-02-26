package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.MainWindow;

public class MainWindow_ActionListener implements ActionListener {

	private MainWindow mainWindow;
	
	public MainWindow_ActionListener(MainWindow mainWindow) {
		this.mainWindow =mainWindow;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("chaxun")){
			mainWindow.btn_ChaXunPerformed();
		}else if(e.getActionCommand().equals("chushou")){
			mainWindow.btn_SellPerformed();
		}else if(e.getActionCommand().equals("daochu")){
			mainWindow.btn_DaoChuPerformed();
		}
	}

}
