package com.jetty.homolo.security.annocation;

import com.jetty.homolo.security.entity.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 16:35 2019/10/27
 */
public class AnnocationTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void test1() {
       Person p = new Person("tom", 34);
        logger.info(p.toString());
   }
}
