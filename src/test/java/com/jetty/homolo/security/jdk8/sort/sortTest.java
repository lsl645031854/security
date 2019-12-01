package com.jetty.homolo.security.jdk8.sort;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-23  上午10:16
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class sortTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	private int[] array = {2,4,1,6,21,12,44};

	@Test
	public void bubbleSortTest() {
		// 冒泡
		int temp;
		for(int i=0; i<array.length-1; i++){   //表示趟数，一共arr.length-1次。
			for(int j=array.length-1; j>i; j--){
				if(array[j] < array[j-1]){
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		for (int i : array) {
			logger.info("第是{}", i);
		}
	}
}
