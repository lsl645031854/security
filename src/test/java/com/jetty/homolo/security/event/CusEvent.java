package com.jetty.homolo.security.event;

import java.io.Serializable;
import java.util.EventObject;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-10-31  下午4:27
 */
public class CusEvent extends EventObject implements Serializable {

	private static final long serialVersionUID = -4776089538876934228L;

	private Object source; // 事件源

	public CusEvent(Object o) {
		super(o);
		this.source = o;
	}

	@Override
	public Object getSource() {
		return this.source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
