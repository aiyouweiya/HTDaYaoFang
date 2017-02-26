package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.model.Employee;
import com.csust.views.FunctionFrame;
import com.csust.views.MainWindow;

public class FunctionFrame_ActionListener implements ActionListener{

	private FunctionFrame functionFrame;
	
	public FunctionFrame_ActionListener(FunctionFrame frame){
		this.functionFrame  = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("销售")){
			functionFrame.sellActionPerformed();
		}else if(command.equals("入库")){
			functionFrame.InActionPerformed();
		}else if(command.equals("人员")){
			functionFrame.peopleManActionPerformed();
		}
	}

}
