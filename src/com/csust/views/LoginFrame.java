/*
 * LoginFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.csust.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.csust.dao.EmpDAOImpl;
import com.csust.listener.LoginFrame_ActionListener;
import com.csust.model.Employee;
import com.csust.utils.PositionHelper;
import com.csust.utils.TextUtils;


public class LoginFrame extends javax.swing.JFrame {

	
	
	private java.util.List<Employee> list;//存储读取的职员的集合
	
	private String initImg = "D:\\Users\\aiyouweiya\\Documents\\Myeclipse\\HTDaYaoFang\\images\\kakaxi.jpg";
	private String mingren = "D:\\Users\\aiyouweiya\\Documents\\Myeclipse\\HTDaYaoFang\\images\\mingren.png";
	private String wanhua = "D:\\Users\\aiyouweiya\\Documents\\Myeclipse\\HTDaYaoFang\\images\\wanhua.jpg";

	private String[] image = new String[] { initImg, mingren, wanhua };

	private String imageURL = "D:\\Users\\aiyouweiya\\Documents\\Myeclipse\\HTDaYaoFang\\images\\jay3.jpg";

	private EmpDAOImpl dao;//操作数据库的实现类
	private DefaultComboBoxModel comboBoxModel;

	/** Creates new form LoginFrame */
	public LoginFrame() {
		initComponents();
		setVisible(true);
	}
	
	
	
//	@Override
//	public void paintComponents(Graphics g) {
//		// TODO Auto-generated method stub
////		super.paintComponents(g);
//		Image image = new ImageIcon(imageURL).getImage();
//		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
//	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		dao = new EmpDAOImpl();
		comboBoxModel = new DefaultComboBoxModel();//下拉列表框的实例模型

		jComboBox1 = new javax.swing.JComboBox();
		jComboBox1.setActionCommand("toggleUser");
		jComboBox1.addActionListener(new LoginFrame_ActionListener(this));
		list = dao.getAllEmps();
		setComBox(list);

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(imageURL).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
			
			
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("姓名：");

		jLabel2.setText("\u5bc6\u7801\uff1a");

		// jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]
		// {
		// "Item 1", "Item 2", "Item 3", "Item 4" }));

		jButton1.setText("\u767b\u9646");
		// jButton1.setActionCommand("login");
		jButton1.setActionCommand("login");
		jButton1.addActionListener(new LoginFrame_ActionListener(this));

		// jLabel3.setText("jLabel3");

		jLabel3.setIcon(new ImageIcon(image[0]));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 604,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 268,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(56, 56, 56)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		198,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		243,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		116,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(57, 57,
																		57)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel2))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jPasswordField1)
																				.addComponent(
																						jComboBox1,
																						0,
																						190,
																						Short.MAX_VALUE))))
								.addGap(107, 107, 107))
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(jPanel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jComboBox1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(48, 48,
																		48)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jPasswordField1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						31,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(49, 49,
																		49)
																.addComponent(
																		jButton1))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(1, 1, 1)
																.addComponent(
																		jLabel3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		105,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		setResizable(false);
		setTitle("华佗大药房");
		// setUndecorated(true);
		pack();
		PositionHelper.centerInScreen(this);
	}// </editor-fold>

	
	/**
	 * 将从数据库中读取出的数据放到list集合中 
	 * @param list 存放职员
	 */
	private void setComBox(java.util.List<Employee> list) {
		for (Employee emp : list) {//轮询list集合，获取到每一个职员
			comboBoxModel.addElement(emp.getName() + " " + emp.getJobID()+" " +emp.getPosition());//将职员姓名，工作号，职位放到下拉列表框中
//			comboBoxModel.addElement(emp);
		}
		jComboBox1.setModel(comboBoxModel);//为下拉列表框设z置实例模型
	}

	// GEN-END:initComponents

	/**
	 * 登陆按钮的点击事件，验证密码为空弹出提示信息：请输入密码，否则查询数据库密码是否正确
	 */
	public void btnLogin_actionPerformed() {
		String password = jPasswordField1.getText().toString();//获取密码框的内容
		String jobID = jComboBox1.getSelectedItem().toString().split(" ")[1].toString();//获取下拉列表框的选项
		if (!TextUtils.isNull(password)) {
			//验证密码的正确性
			if (dao.passIsValid(jobID, password)) {
				Employee real=null;
				for(Employee emp:list){
					if(emp.getJobID().equals(jobID)){
						 real = emp;
						break;
					}
				}
				//密码正确是弹出功能界面
				new FunctionFrame(real);
//				new MainWindow(real);
				dispose();
			} else {
				//密码错误弹出提示信息
				JOptionPane.showMessageDialog(this, "您输入的密码有误");
			}
		} else {
			//密码为空时弹出提示信息
			JOptionPane.showMessageDialog(this, "请输入密码！！！");
		}

	}
	
	/**
	 * 下拉列表点击事件，选择不同item会触发这个事件
	 */
	public void comBox_actionPerformed() {
		//获取下拉列表框的选项
		int index = jComboBox1.getSelectedIndex();
		//针对不同的角色选择不同的头像
		jLabel3.setIcon(new ImageIcon(image[index%3]));
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField jPasswordField1;
	// End of variables declaration//GEN-END:variables

}