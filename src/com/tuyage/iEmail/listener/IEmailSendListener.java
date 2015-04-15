package com.tuyage.iEmail.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tuyage.iEmail.diary.IEmailDiary;
import com.tuyage.iEmail.sendmail.IEmailMailSender;
import com.tuyage.iEmail.sendmail.IEmailSendConnector;

/**
 * 发送界面的监听实现。
 * @author LeoTse
 */
public class IEmailSendListener implements ActionListener{
	
	// 声明一个字符串用来保存包装后的消息体
	public static String mail = "";

	/**
	 * 实现对邮件编辑的监听。
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		String actStr = e.getActionCommand();
		if(actStr.equals("Send..")){
			// 连接服务器端
			IEmailSendConnector.sendConnector();
			// 发送邮件
			IEmailMailSender ims = new IEmailMailSender();
			boolean res = ims.sendMail();
			if(res){
				IEmailDiary.INFORMATION(this.getClass(), "Succeed to send mail!");
			}else{
				IEmailDiary.INFORMATION(this.getClass(), "Failed to send mail!");
			} // end if-else
		} // end if
	} // end actionPerformed

} // end class IEmailSendListener
