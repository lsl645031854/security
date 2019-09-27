package com.jetty.homolo.security.interaction;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-27  上午10:16
 */
public class Message {

	private String type;
	private String desc;
	private int code;
	private Object content;

	public Message(String type, String desc, Object content) {
		this.type = type;
		this.desc = desc;
		this.content = content;
	}

	public Message(int code, String desc) {
		this.desc = desc;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Message() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message{" + "type='" + type + '\'' + ", desc='" + desc + '\'' + ", content=" + content + '}';
	}
}
