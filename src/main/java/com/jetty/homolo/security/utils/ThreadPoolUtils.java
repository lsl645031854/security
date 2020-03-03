/**
 * Project:justice-mediation-beijing-webapp-0706
 * File:ThreadPoolUtils.java
 * Copyright 2004-2018 Homolo Co., Ltd. All rights reserved.
 */
package com.jetty.homolo.security.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 定义线程池执行线程（初始化失败用这个吧．．．）
 * @author homolo
 * @date 2018年11月17日
 */
public class ThreadPoolUtils {
	/**
	 *  核心线程:100
	 *  最大线程:300
	 *  等待时间:30s
	 */
	public final static ThreadPoolExecutor TH_FAC = new ThreadPoolExecutor(100, 300, 30, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>());
	public static void execute(Runnable command) {
//		thFac.allowCoreThreadTimeOut(true); //即使不大于核心线程也在设置时间后关闭
		TH_FAC.execute(command);
	}

	public static Future<?> submit(Runnable task) {
//		thFac.allowCoreThreadTimeOut(true); //即使不大于核心线程也在设置时间后关闭
		if (task == null) {
			throw new NullPointerException();
		}
		RunnableFuture<Void> ftask = (RunnableFuture<Void>) TH_FAC.submit(task);
		return ftask;
	}

	public static Future<String> submitTask(Callable<String> task) {
		if (task == null) {
			throw new NullPointerException();
		}
		return TH_FAC.submit(task);
	}
}
