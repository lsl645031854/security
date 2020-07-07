package com.jetty.homolo.security.exception;

import org.junit.Test;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-11-16  上午10:54
 */
public class ExceptionTest {

	@Test
	public void test() {
		try {
			try {
				throw new ExceptionB("exception b");
			} catch (ExceptionA a) {
				System.out.println(a.getMessage()); // a的真实类型还是 ExceptionB，所有可以被ExceptionB捕获
				throw a;
			}
		} catch (ExceptionB b) {
			System.out.println("catch b");
			return;
		} finally {
			System.out.println("hello world");
		}
	}
}
