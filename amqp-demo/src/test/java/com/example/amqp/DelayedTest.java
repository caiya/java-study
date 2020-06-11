package com.example.amqp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

/**
 * @author caiya
 * @date 2020/6/8 20:47
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DelayedTest {

    @Autowired
    private DelayedSender sender;

    @Test
    public void Test() throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        sender.send("10s.", 10000);
        sender.send("1s.", 1000);
        sender.send("5s.", 5000);
        sender.send("4s.", 4000);
        sender.send("20s.", 20000);

        Thread.sleep(1000000 * 1000); //等待接收程序执行之后，再退出测试
    }
}