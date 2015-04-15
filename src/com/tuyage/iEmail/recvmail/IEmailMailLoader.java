package com.tuyage.iEmail.recvmail;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.tuyage.iEmail.clientUI.IEmailRecvLoginUI;
import com.tuyage.iEmail.clientUI.IEmailRecvUI;
import com.tuyage.iEmail.diary.IEmailDiary;

/**
 * 从标准服务器下载邮件。
 * @author LeoTse
 */
public class IEmailMailLoader {
	
	// 声明输入输出流
	private static DataInputStream dins = IEmailRecvConnector.dins;
	private static DataOutputStream dous = IEmailRecvConnector.dous;
	
	// 声明一个换行符
	static String LINEFEET = "\n\r";
	
	/**
	 * 下载邮件到客户端。
	 */
	@SuppressWarnings("deprecation")
	public void recvMail(){
		// 得到输入的用户名和密码
		String uName = IEmailRecvLoginUI.nameField.getText();
		String uPwd = IEmailRecvLoginUI.pwdField.getText();
		IEmailDiary.INFORMATION(this.getClass(), " uName: " + uName + "&uPwd: " + uPwd);
		// 将用户名和密码发送到标准服务器验证
		String res1 = sendMsg("USER " + uName + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "USER: " + res1);
		String res2 = sendMsg("PASS " + uPwd + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "PASS: " + res2);
		String res3 = sendMsg("STAT" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "STAT: " + res3);
		String res4 = sendMsg("LIST" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "LIST: " + res4);
		String res5 = sendMsg("RETR " + 1 + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "RETR: " + res5);
		String res6 = sendMsg("TOP " + 1 + " " + 20 + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "TOP: " + res6);
		for(int i = 0; i < 60; i ++){
			String res = response();
			try {
				res = new String(res.getBytes("ISO-8859-1"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println(res);
			IEmailRecvUI.str += res + "\n";
		} // end for
		String res7 = sendMsg("QUIT" + LINEFEET);
		IEmailDiary.INFORMATION(this.getClass(), "QUIT: " + res7);
	} // end recvMail
	
	/**
	 * 发送一条信息。
	 * @param str 要发送的消息
	 * @return 返回读取到的字符串
	 */
	private String sendMsg(String str){
		// 声明
		String res = null;
		try {
			// 写入输出流
			dous.writeBytes(str);
			dous.flush();
			res = response();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to write dous.");
		} // end try-catch
		return res;
	} // end sendMsg
	
	/**
	 * 从输入流中读取消息。
	 * @return 读取到的字符串
	 */
	@SuppressWarnings("deprecation")
	private String response(){
		// 声明一个字符串
		String res = null;
		try {
			res = dins.readLine();
		} catch (IOException e) {
			IEmailDiary.EXCEPTION(this.getClass(), e, "Read from dins failed.");
		} // end try-catch
		return res;
	} // end response
	
	/**
	 * 关闭输入输出流。
	 */
//	private void close(){
//		try {
//			// 关闭输入输出流
//			dins.close();
//			dous.close();
//		} catch (IOException e) {
//			IEmailDiary.EXCEPTION(this.getClass(), e, "Failed to close streams.");
//		} // end try-catch
//	} // end close

} // end class IEmailMailLoader
