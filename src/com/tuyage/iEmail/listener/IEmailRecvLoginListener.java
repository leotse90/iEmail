package com.tuyage.iEmail.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tuyage.iEmail.clientUI.IEmailRecvUI;
import com.tuyage.iEmail.recvmail.IEmailMailLoader;
import com.tuyage.iEmail.recvmail.IEmailRecvConnector;

/**
 * ʵ�ֶ������ʼ��ͻ��˵�¼����ļ�����
 * @author LeoTse
 */
public class IEmailRecvLoginListener implements ActionListener{

	/**
	 * ������ť�Ķ�����
	 */
	public void actionPerformed(ActionEvent e) {
		// �õ���ť�ϵ��ı�
		String str = e.getActionCommand();
		if(str.equals("Confirm")){
			// ����һ��IEmailRecvLoginUI���󲢵�������ʾ����ķ���
			// ��������
			IEmailRecvConnector.recvConnector();
			// ����
			IEmailMailLoader im = new IEmailMailLoader();
			im.recvMail();
			IEmailRecvUI irlu = new IEmailRecvUI();
			irlu.showUI();
		} // end if
	} // end actionPerformed
 
} // end class IEmailRecvLoginListener
