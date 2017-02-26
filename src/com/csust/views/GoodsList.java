/*
 * GoodsList.java
 *
 * Created on __DATE__, __TIME__
 */

package com.csust.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.csust.dao.YaoDAOImpl;
import com.csust.model.Yao;
import com.csust.utils.ExcelUtils;
import com.csust.utils.PositionHelper;


public class GoodsList extends javax.swing.JDialog implements ActionListener {

	private Vector<Vector<Object>> data;

	public GoodsList(JDialog parent, boolean modal,
			Vector<Vector<Object>> data, Vector<Object> titles) {
		this.data = data;
		initComponents();
		jTable1.setModel(new DefaultTableModel(data, titles));
		int rows = jTable1.getRowCount();
		Double price = (double) 0;
		for (int i = 0; i < rows; i++) {
			price += Double
					.parseDouble(String.valueOf(jTable1.getValueAt(i, 5)));
		}
		// System.out.println(price);
		jLabel3.setText(String.valueOf(price));
		PositionHelper.centerInScreen(this);
		setVisible(true);
	}

	public void btn_YesPerformed() {
		// System.out.println("yes");
		int rows = jTable1.getRowCount();
		List<Yao> yaos = new YaoDAOImpl().getAllYao();
		boolean rs = false;
		boolean bool = false;
		for (int i = 0; i < rows; i++) {
			boolean yes = false;
			for (Yao yao1 : yaos) {
				if (yao1.getBianhao().equals((String) jTable1.getValueAt(i, 0))) {
					// System.out.println((String)jTable1.getValueAt(i,5));
					// System.out.println();
					yes = true;
					int newCount = Integer.valueOf((String) jTable1.getValueAt(
							i, 5)) + yao1.getRemainCount();
					rs = new YaoDAOImpl()
							.updateYao(yao1.getBianhao(), newCount);
				}
			}
			if (yes == false) {
				Yao yao = new Yao();
				yao.setBianhao((String) jTable1.getValueAt(i, 0));
				yao.setName((String) jTable1.getValueAt(i, 1));
				yao.setType((String) jTable1.getValueAt(i, 2));
				yao.setSellPrice(Double.valueOf((String) jTable1.getValueAt(i,
						3)));
				yao.setPifaPrice(Double.valueOf((String) jTable1.getValueAt(i,
						4)));
				yao.setRemainCount((Integer.valueOf((String) jTable1
						.getValueAt(i, 5))));
				// System.out.println(yao.toString());
				bool = new YaoDAOImpl().insertYao(yao);
			}
		}
		if(rs&&bool){
			JOptionPane.showMessageDialog(this, "进货成功");
		}
		dispose();
	}

	public void btn_DaochuPerformed() {
		// System.out.println("daochu");
		//[1001, 马钱子, 中药, 100.0, 80.0, 2, 160.0]  Vector 
		int count = data.size();
		String[] pifaNum = new String[count];
		String[] price = new String[count];
		List<Yao> yaos = new ArrayList<Yao>();
 		for(int i=0;i<count;i++){
			Yao yao = new Yao();
			yao.setBianhao((String)data.elementAt(i).get(0));
			yao.setName((String)data.elementAt(i).get(1));
			yao.setType((String)data.elementAt(i).get(2));
			yao.setSellPrice(Double.valueOf((String)data.elementAt(i).get(3)));
			yao.setPifaPrice(Double.valueOf((String)data.elementAt(i).get(4)));
//			yao.setRemainCount(Integer.valueOf((String)data.elementAt(i).get(5)));
			pifaNum[i] = data.elementAt(i).get(5)+"";
			price[i] = data.elementAt(i).get(6)+"";
			yaos.add(yao);
//			System.out.println(yao.toString()+pifaNum[i]+price[i]);
		}
 		JFileChooser chooser = new JFileChooser();
		if(chooser.showSaveDialog(this)==1){
			return;
		}
		String path = chooser.getCurrentDirectory().getPath();
		String path1 = path.replace('\\','/');
		String fileName = chooser.getSelectedFile().getName();
		String realPath = path1+"/"+fileName;
		if(ExcelUtils.exportPifaExcel(yaos,pifaNum,price,realPath)){
			JOptionPane.showMessageDialog(this, "导出成功");
		}
		dispose();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 22));
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("\u8fdb\u8d27\u6e05\u5355");

		jTable1.setBackground(new Color(255, 251, 240));
		jTable1.getTableHeader().setBackground(new Color(166, 202, 240));
		// Microsoft YaHei UI 20 Plain
		jTable1.getTableHeader().setFont(
				new Font("Microsoft YaHei UI", Font.BOLD, 20));
		jTable1.setRowHeight(30);
		jTable1.setRowMargin(10);
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "编号", "名称", "类型", "售价", "批发价", "批发数量", "总价" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("\u5bfc\u51fa");
		jButton1.setActionCommand("daochu");
		jButton1.addActionListener(this);

		jButton2.setText("\u786e\u8ba4");
		jButton2.setActionCommand("yes");
		jButton2.addActionListener(this);

		jLabel2.setText("\u603b\u4ef7\uff1a");

		jLabel3.setText("jLabel3");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(43, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		101,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(82, 82,
																		82)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		99,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(224,
																		224,
																		224))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addGap(344,
																		344,
																		344))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										jLabel3))
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						665,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(53, 53,
																		53)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										354,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(35, 35, 35)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(jLabel3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										16, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap()));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;

	// End of variables declaration//GEN-END:variables
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("daochu")) {
			btn_DaochuPerformed();
		} else if (command.equals("yes")) {
			btn_YesPerformed();
		}
	}

}