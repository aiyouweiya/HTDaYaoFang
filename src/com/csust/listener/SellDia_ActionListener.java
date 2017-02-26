package com.csust.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.csust.views.SellDia;

public class SellDia_ActionListener implements ActionListener{

	private SellDia sellDia;
	
	public SellDia_ActionListener(SellDia sellDia) {
		this.sellDia = sellDia;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("queren")){
			sellDia.btn_querenActionPerformed();
		}else if(e.getActionCommand().equals("qingkong")){
			sellDia.btn_qingkongActionPerformed();
		}else if(e.getActionCommand().equals("querengoumai")){
			sellDia.btn_querengoumaiPerformed();
		}
	}

}
