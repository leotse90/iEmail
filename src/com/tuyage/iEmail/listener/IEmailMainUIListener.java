package com.tuyage.iEmail.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tuyage.iEmail.clientUI.IEmailRecvLoginUI;
import com.tuyage.iEmail.clientUI.IEmailSendUI;

/**
 * ������ļ�����ʵ���ࡣ
 * @author LeoTse
 */
public class IEmailMainUIListener implements ActionListener{

	/**
	 * �԰�ť�����ֱ���м�����
	 */
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("Send e-mail")){
			// ��ת�������ʼ�����
			IEmailSendUI isu = new IEmailSendUI();
			isu.showUI();
		}else if(action.equals("Load e-mail")){
			// ��ת�������ʼ��Ľ���
			IEmailRecvLoginUI irlu = new IEmailRecvLoginUI();
			irlu.showUI();
		} // end if-else
		
	} // end actionPerformed

} // end class MainUIListener
