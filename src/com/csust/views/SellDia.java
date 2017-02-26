/*
 * SellDia.java
 *
 * Created on __DATE__, __TIME__
 */

package com.csust.views;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.csust.dao.YaoDAOImpl;
import com.csust.listener.SellDia_ActionListener;
import com.csust.model.Yao;
import com.csust.utils.PositionHelper;


public class SellDia extends javax.swing.JDialog {

	private  Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	private  Vector<String> titles = new Vector<String>();
	private DefaultTableModel tableModel;

	/** Creates new form SellDia */
	public SellDia(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setTitle("出售药单");
		PositionHelper.centerInScreen(this);
		setVisible(true);
	}

	public void btn_qingkongActionPerformed(){
		int choice = JOptionPane.showConfirmDialog(this, "确认清空？？");
		if(choice==JOptionPane.YES_OPTION){
			data.clear();
			tableModel.setDataVector(data, titles);
			jTable1.setModel(tableModel);
		}
	}
	
	public void btn_querengoumaiPerformed(){
		int rowCount = jTable1.getRowCount();
		if(rowCount==0){
			JOptionPane.showMessageDialog(this, "请检查您的药品信息");
			return ;
		}
		int sum=0;
		for(int i=0;i<rowCount;i++){
			Double money = (Double) jTable1.getValueAt(i, 5);
			sum+=money;
		}
		dispose();
		new YaoList((JFrame)SellDia.this.getParent(), true,data,titles,sum);
//		System.out.println(sum);
	}
	
	public void btn_querenActionPerformed() {
		String yao = jTextField1.getText().toString();
		String num = jTextField2.getText().toString();
		Yao realYao = null;// 待查找的药；
		if (num == null || "".equals(num)) {
			JOptionPane.showMessageDialog(this, "请输入药品数量");
		} else if (Integer.parseInt(num) <= 0) {
			JOptionPane.showMessageDialog(this, "请输入正确的数量");
		}
		if (yao == null || "".equals(yao)) {
			JOptionPane.showMessageDialog(this, "请输入药品编号");
		} else {
			List<Yao> list = new YaoDAOImpl().getAllYao();
			for (Yao yaoInList : list) {
				if (yaoInList.getName().equals(yao)) {
					// TODO 找到药品
					realYao = yaoInList;
					Vector<Object> item = new Vector<Object>();
					item.addElement(realYao.getBianhao());
					item.addElement(realYao.getName());
					item.addElement(realYao.getType());
					item.addElement(realYao.getSellPrice());
					item.addElement(Integer.parseInt(num));
					item.addElement(realYao.getSellPrice()
							* Integer.parseInt(num));
					data.add(item);
					if(realYao!=null&&(realYao.getRemainCount()<Integer.parseInt(jTextField2.getText()))){
						JOptionPane.showMessageDialog(this, "你选购的"+realYao.getName()+"库存只有"+realYao.getRemainCount()+"件，购买失败");
						data.remove(item);
					}
				}
			}
			tableModel.setDataVector(data, titles);
			jTable1.setModel(tableModel);
		}
		if (realYao == null) {
			JOptionPane.showMessageDialog(this, "您输入的药品不存在");
		}
		jTextField1.setText("");
		jTextField2.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		tableModel = new DefaultTableModel();

		titles.addElement("编号");
		titles.addElement("名称");
		titles.addElement("类型");
		titles.addElement("售价");
		titles.addElement("数量");
		titles.addElement("总价");

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u51fa\u552e");

		jTable1.getTableHeader().setBackground(new Color(166, 202, 240));
		// Microsoft YaHei UI 20 Plain
		jTable1.getTableHeader().setFont(
				new Font("Microsoft YaHei UI", Font.BOLD, 24));
		jTable1.setRowHeight(30);
		jTable1.setRowMargin(10);

		jLabel2.setText("名称");

		jTable1.setBackground(new java.awt.Color(255, 251, 240));
		jTable1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20));
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {}, new String[] {
						"编号", "名称", "类型", "售价", "数量", "总价" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("\u786e\u8ba4\u8d2d\u4e70");
		jButton1.setActionCommand("querengoumai");
		jButton1.addActionListener(new SellDia_ActionListener(this));

		jButton2.setText("\u6e05\u7a7a");
		jButton2.setActionCommand("qingkong");
		jButton2.addActionListener(new SellDia_ActionListener(this));

		jButton3.setText("\u786e\u8ba4");
		jButton3.setActionCommand("queren");
		jButton3.addActionListener(new SellDia_ActionListener(this));

		jLabel3.setText("\u6570\u91cf\uff1a");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(

						javax.swing.GroupLayout.Alignment.LEADING).addGroup(

						layout.createSequentialGroup()

						.addGap(276,

						276,

						276)

						.addComponent(

						jLabel1)).addGroup(

						layout.createSequentialGroup()

						.addGap(77, 77,

						77)

						.addComponent(

						jLabel2)

						.addPreferredGap(

						javax.swing.LayoutStyle.ComponentPlacement.RELATED)

						.addComponent(

						jTextField1,

						javax.swing.GroupLayout.PREFERRED_SIZE,

						136,

						javax.swing.GroupLayout.PREFERRED_SIZE)

						.addGap(27, 27,

						27)

						.addComponent(

						jLabel3)

						.addPreferredGap(

						javax.swing.LayoutStyle.ComponentPlacement.RELATED)

						.addComponent(

						jTextField2,

						javax.swing.GroupLayout.PREFERRED_SIZE,

						136,

						javax.swing.GroupLayout.PREFERRED_SIZE)

						.addGap(87, 87,

						87)

						.addComponent(

						jButton3)).addGroup(

						layout.createSequentialGroup()

						.addGap(37, 37,

						37)

						.addComponent(

						jScrollPane1,

						javax.swing.GroupLayout.PREFERRED_SIZE,

						693,

						javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(

						layout.createSequentialGroup()

						.addGap(220,

						220,

						220)

						.addComponent(

						jButton1,

						javax.swing.GroupLayout.PREFERRED_SIZE,

						117,

						javax.swing.GroupLayout.PREFERRED_SIZE)

						.addGap(90, 90,

						90)

						.addComponent(

						jButton2,

						javax.swing.GroupLayout.PREFERRED_SIZE,

						112,

						javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(40, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addPreferredGap(

						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(

								javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent

										(jLabel2).addComponent(

										jTextField1,

										javax.swing.GroupLayout.PREFERRED_SIZE,

										javax.swing.GroupLayout.DEFAULT_SIZE,

										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent

										(jLabel3).addComponent(

										jTextField2,

										javax.swing.GroupLayout.PREFERRED_SIZE,

										javax.swing.GroupLayout.DEFAULT_SIZE,

										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent

										(jButton3))
						.addGap(37, 37, 37)
						.addComponent(jScrollPane1,

						javax.swing.GroupLayout.PREFERRED_SIZE, 495,

						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(

						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(

								javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(

										jButton1,

										javax.swing.GroupLayout.DEFAULT_SIZE,
												41,

												Short.MAX_VALUE)
										.addComponent(

										jButton2,

										javax.swing.GroupLayout.DEFAULT_SIZE,
												41,

												Short.MAX_VALUE))
						.addGap(27, 27, 27)));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	public static javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}