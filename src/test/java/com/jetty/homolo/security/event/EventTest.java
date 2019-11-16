package com.jetty.homolo.security.event;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-10-31  下午5:01
 */
public class EventTest {
	public static void main(String[] args) {
		EventSourceObject object = new EventSourceObject();
		object.addCusListener(new CusEventListener());
		object.setName("123");

		String string = Integer.toOctalString(15); // 转进制
		System.out.println(string);
	}
}
