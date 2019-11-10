package com.codeshop.spring.cloud.util;

import java.net.Socket;

public class NetUtil {
    // 判断本地端口是否可用
    public static boolean isLocalPortUsing(int port) {
        try {
            new Socket("127.0.0.1", port).close();
            // socket连接正常，说明该端口占用
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
