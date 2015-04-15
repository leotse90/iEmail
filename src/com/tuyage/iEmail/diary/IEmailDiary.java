package com.tuyage.iEmail.diary;

/**
 * iEmail的日志管理类。
 * @author LeoTse
 */
public class IEmailDiary {
	
	// 声明一个
	private static boolean FLAG = true;
	
	/**
	 * 打印普通方法的普通消息。
	 * @param c 需要打印消息的类
	 * @param info 要打印的消息
	 */
	public static void INFORMATION(Class<?> c, String info){
		if(FLAG){
			System.out.println(">> " + c.getName() + " : " + info);
		} // end if
	} // end INFORMATION
	
	/**
	 * 打印普通方法的异常信息。
	 * @param c 需要打印异常的类
	 * @param ef 抛出的异常
	 * @param info 要打印的消息
	 */
	public static void EXCEPTION(Class<?> c, Exception e, String info){
		if(FLAG){
			System.out.println("<< " + c.getName() + " : " + info);
			e.printStackTrace();
		} // end if
	} // end EXCEPTION
	
	/**
	 * 打印静态方法的普通消息。
	 * @param className 需要打印的类
	 * @param info 要打印的消息
	 */
	public static void INFORMATIONS(String className, String info){
		if(FLAG){
			System.out.println(">> " + className + " : " + info);
		} // end if 
	} // end INFORMATIONS
	
	/**
	 * 打印静态方法的异常信息。
	 * @param className 要打印消息的类
	 * @param e 抛出的异常
	 * @param info 要打印的消息
	 */
	public static void EXCEPTIONS(String className, Exception e, String info){
		if(FLAG){
			System.out.println("<< " + className + " : " + info);
			e.printStackTrace();
		} // end if
	} // end EXCEPTIONS

} // end class IEmailDiary
