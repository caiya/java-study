package com.codeshop.spring.cloud.util;

import java.util.Random;

public class ServerPortUtil {
    /**
     * 获取闲置端口，采用随机递归方式
     * @return
     */
    public static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random random = new Random();
        int port = random.nextInt(max) % (max - min + 1) + min;
        // 判断端口是否可用
        boolean isLocalPortUsing = NetUtil.isLocalPortUsing(port);
        if (isLocalPortUsing) {
            // 端口占用，继续遍历
            return getAvailablePort();
        } else {
            // 端口没有占用，返回有效端口
            return port;
        }
    }
}
