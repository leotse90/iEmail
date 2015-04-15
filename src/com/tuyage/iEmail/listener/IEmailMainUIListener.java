package com.tuyage.iEmail.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tuyage.iEmail.clientUI.IEmailRecvLoginUI;
import com.tuyage.iEmail.clientUI.IEmailSendUI;

/**
 * 主界面的监听器实现类。
 * @author LeoTse
 */
public class IEmailMainUIListener implements ActionListener{

	/**
	 * 对按钮动作分别进行监听。
	 */
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("Send e-mail")){
			// 跳转到发送邮件界面
			IEmailSendUI isu = new IEmailSendUI();
			isu.showUI();
		}else if(action.equals("Load e-mail")){
			// 跳转到下载邮件的界面
			IEmailRecvLoginUI irlu = new IEmailRecvLoginUI();
			irlu.showUI();
		} // end if-else
		
	} // end actionPerformed

} // end class MainUIListener
