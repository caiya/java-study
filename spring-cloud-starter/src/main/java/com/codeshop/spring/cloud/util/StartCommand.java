package com.codeshop.spring.cloud.util;

import org.springframework.util.StringUtils;

public class StartCommand {
    public StartCommand(String[] args) {
        boolean isServerPort = false;
        String serverPort = "";
        if (args != null) {
            for (String arg: args) {
                if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
                    isServerPort = true;
                    serverPort = arg;
                    break;
                }
            }
        }
        // 如果没有指定端口
        if (!isServerPort) {
            int port = ServerPortUtil.getAvailablePort();
            System.setProperty("server.port", String.valueOf(port));
        } else {
            System.setProperty("server.port", serverPort.split("=")[1]);
        }
    }

}
