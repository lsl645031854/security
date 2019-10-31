package com.jetty.homolo.security.event;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author homolo
 * @DESC 事件源里注册了事件的所有监听器
 * 事件源里含有触发侦听器的条件，
 * @Create 2019-10-31  下午4:33
 */
public class EventSourceObject {
	private String name;
	//监听器容器  
	private Set<CusEventListener> listeners;
	public EventSourceObject() {
		this.listeners = new HashSet<>();
		this.name = "defaultName";
	}
	// 给事件源注册监听器
	public void addCusListener(CusEventListener cusEventListener) {
		listeners.add(cusEventListener);
	}
	// 当事件发生时，通知注册在该事件源的所有监听器，做出反应
	protected void notifies() {
		CusEventListener cusEventListener;
		for (CusEventListener listener : this.listeners) {
			cusEventListener = listener;
			cusEventListener.fireCusEvent(new CusEvent(this));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(!this.name.equals(name)){
			this.name = name;
			notifies();
		}
	}
}
