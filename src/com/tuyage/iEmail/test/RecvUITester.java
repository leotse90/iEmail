package com.tuyage.iEmail.test;

import com.tuyage.iEmail.clientUI.IEmailRecvUI;

/**
 * 接收邮件客户端的测试类。
 * @author LeoTse
 */
public class RecvUITester {
	
	/**
	 * 主函数。
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个IEmailRecvUI对象
		IEmailRecvUI ru = new IEmailRecvUI();
		ru.showUI();
	} // end main

} // end class RecvUITester
