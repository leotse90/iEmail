package com.tuyage.iEmail.test;

import com.tuayge.iEmail.resolve.IEmailMsgPartition;

/**
 * 测试Add中@前部分。
 * @author LeoTse
 */
public class EmailAddTester {
	
	/**
	 * 主函数。
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "<>xiefeng</><>jiuji</>";
		String res = "";
		res = IEmailMsgPartition.partitionEmail(str);
		System.out.println(res);
	} // end main

} // end class EmailAddTester
