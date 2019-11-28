package com.jetty.homolo.security.exception;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-11-16  上午10:52
 */
public class ExceptionA extends Exception {
	public ExceptionA(String message) {
		super(message);
	}
}

class ExceptionB extends ExceptionA {
	public ExceptionB(String message) {
		super(message);
	}}