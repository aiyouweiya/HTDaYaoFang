package com.csust.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.csust.views.MainWindow;

public class MainWindow_KeyListener extends KeyAdapter{

	private MainWindow mainWindow;
	
	public MainWindow_KeyListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			mainWindow.enterDownPerformed();
		}
	}
	
}
