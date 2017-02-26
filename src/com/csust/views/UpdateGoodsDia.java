/*
 * UpdateGoodsDia.java
 *
 * Created on __DATE__, __TIME__
 */

package com.csust.views;

import java.util.List;

import javax.swing.JOptionPane;

import com.csust.dao.YaoDAOImpl;
import com.csust.listener.UpdateGoodsDia_ActionListener;
import com.csust.model.Yao;
import com.csust.utils.PositionHelper;


public class UpdateGoodsDia extends javax.swing.JDialog {

	private Yao yao;
	private List<Yao> list;
	/** Creates new form UpdateGoodsDia */
	public UpdateGoodsDia(java.awt.Frame parent, boolean modal,Yao yao,List<Yao> list) {
		super(parent, modal);
		this.yao = yao;
		this.list = list;
		initComponents();
		PositionHelper.centerInScreen(this);
		setVisible(true);
	}
	
	public void btn_YesPerformed() {
//		System.out.println("yes");
		boolean sure = false;
		GarageManageFrame parent = (GarageManageFrame) getParent();
		String bianhao = jTextField1.getText().toString();
		String mingzi = jTextField2.getText().toString();
		String type = jComboBox1.getSelectedItem().toString();
		String price = jTextField3.getText().toString();
		String pifa  =jTextField4.getText().toString();
		int rows = parent.jTable1.getRowCount();
		for(int i=0;i<rows;i++){
			String num = (String) parent.jTable1.getValueAt(i, 0);
			String name = (String) parent.jTable1.getValueAt(i, 1);
			
			if(num.equals(bianhao)){
				if(parent.jTable1.getSelectedRow()!=i){
					sure = true;
					JOptionPane.showMessageDialog(this, "您要修改的药品编号已存在");
				}
			}
			if(name.equals(mingzi)){
				if(parent.jTable1.getSelectedRow()!=i){
					sure = true;
					JOptionPane.showMessageDialog(this, "您要修改的药品名称已存在");
				}
			}
		}
		
		if(sure==true){
			return;
		}else{
			if(JOptionPane.showConfirmDialog(this, "确认修改")!=0){
				return;
			}else{
				Yao yao = new Yao();
				yao.setBianhao(bianhao);
				yao.setName(mingzi);
				yao.setPifaPrice(Double.valueOf(pifa));
				yao.setSellPrice(Double.valueOf(price));
				yao.setType(type);
				if(new YaoDAOImpl().updateYao(yao,(String)parent.jTable1.getValueAt(parent.jTable1.getSelectedRow(), 0))){
					JOptionPane.showMessageDialog(this, "更新成功");
				}
				
				
				int select = parent.jTable1.getSelectedRow();
				parent.jTable1.setValueAt(bianhao, select, 0);
				parent.jTable1.setValueAt(mingzi, select, 1);
				parent.jTable1.setValueAt(type, select, 2);
				parent.jTable1.setValueAt(price, select, 3);
				parent.jTable1.setValueAt(pifa, select, 4);
				dispose();
			}
		}
		
		
		
	}
	
	public void btn_ClearPerformed(){
//		System.out.println("clear");
		jComboBox1.setSelectedItem(yao.getType());
		jTextField1.setText(yao.getBianhao());
		jTextField2.setText(yao.getName());
		jTextField3.setText(String.valueOf(yao.getPifaPrice()));
		jTextField4.setText(String.valueOf(yao.getSellPrice()));
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField1.setEditable(false);
		jTextField2 = new javax.swing.JTextField();
		jTextField2.setEditable(false);
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox1.setEnabled(false);
		jTextField3 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("\u7f16\u53f7\uff1a");

		jLabel2.setText("\u540d\u79f0\uff1a");

		jLabel3.setText("\u7c7b\u578b\uff1a");

		jLabel4.setText("\u6279\u53d1\u4ef7\uff1a");

		jTextField1.setText(yao.getBianhao());

		jTextField2.setText(yao.getName());

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"中药", "西药", "处方内", "处方外","非处方内","非处方外" }));
		jComboBox1.setSelectedItem(yao.getType());

		jTextField3.setText(String.valueOf(yao.getPifaPrice()));

		jLabel5.setText("\u552e\u4ef7\uff1a");

		jTextField4.setText(String.valueOf(yao.getSellPrice()));

		jLabel6.setText("\u836f\u54c1\u4fee\u6539\u5355");

		jButton1.setText("\u786e\u5b9a");
		jButton1.setActionCommand("yes");
		jButton1.addActionListener(new UpdateGoodsDia_ActionListener(this));

		jButton2.setText("\u8fd8\u539f");
		jButton2.setActionCommand("clear");
		jButton2.addActionListener(new UpdateGoodsDia_ActionListener(this));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(154,
																		154,
																		154)
																.addComponent(
																		jLabel6))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(34, 34,
																		34)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										jLabel1)
																								.addComponent(
																										jLabel2))
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel5))
																.addGap(31, 31,
																		31)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						jTextField4,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jComboBox1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						0,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField2,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						191,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(83, Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(71, Short.MAX_VALUE)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										98,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(84, 84, 84)
								.addComponent(jButton2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										99,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(59, 59, 59)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(13, 13, 13)
								.addComponent(jLabel6)
								.addGap(35, 35, 35)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(54, 54, 54)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel2)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(61, 61, 61)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jComboBox1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3))
								.addGap(51, 51, 51)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(49, 49, 49)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										37, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton2)
												.addComponent(jButton1))
								.addGap(33, 33, 33)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	// End of variables declaration//GEN-END:variables

}