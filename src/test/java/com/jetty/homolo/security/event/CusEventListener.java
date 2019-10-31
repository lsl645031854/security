package com.jetty.homolo.security.event;

import java.util.EventListener;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-10-31  下午4:32
 */
public class CusEventListener implements EventListener {
	//事件发生后的回调方法  

	public void fireCusEvent(CusEvent e) {
		EventSourceObject eObject = (EventSourceObject) e.getSource();
		System.out.println("My name has been changed!");
		System.out.println("I got a new name,named \"" + eObject.getName() + "\"");
	}
}
