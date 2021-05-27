package com.xyy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author user
 * @date 2021/5/27 - 20:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads(){
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }
}
