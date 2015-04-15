package com.tuyage.iEmail.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tuyage.iEmail.diary.IEmailDiary;
import com.tuyage.iEmail.sendmail.IEmailMailSender;
import com.tuyage.iEmail.sendmail.IEmailSendConnector;

/**
 * ���ͽ���ļ���ʵ�֡�
 * @author LeoTse
 */
public class IEmailSendListener implements ActionListener{
	
	// ����һ���ַ������������װ�����Ϣ��
	public static String mail = "";

	/**
	 * ʵ�ֶ��ʼ��༭�ļ�����
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		String actStr = e.getActionCommand();
		if(actStr.equals("Send..")){
			// ���ӷ�������
			IEmailSendConnector.sendConnector();
			// �����ʼ�
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
