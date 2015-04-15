package com.tuyage.iEmail.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tuyage.iEmail.clientUI.IEmailRecvUI;
import com.tuyage.iEmail.recvmail.IEmailMailLoader;
import com.tuyage.iEmail.recvmail.IEmailRecvConnector;

/**
 * 实现对下载邮件客户端登录界面的监听。
 * @author LeoTse
 */
public class IEmailRecvLoginListener implements ActionListener{

	/**
	 * 监听按钮的动作。
	 */
	public void actionPerformed(ActionEvent e) {
		// 得到按钮上的文本
		String str = e.getActionCommand();
		if(str.equals("Confirm")){
			// 创建一个IEmailRecvLoginUI对象并调用其显示界面的方法
			// 建立连接
			IEmailRecvConnector.recvConnector();
			// 发送
			IEmailMailLoader im = new IEmailMailLoader();
			im.recvMail();
			IEmailRecvUI irlu = new IEmailRecvUI();
			irlu.showUI();
		} // end if
	} // end actionPerformed
 
} // end class IEmailRecvLoginListener
