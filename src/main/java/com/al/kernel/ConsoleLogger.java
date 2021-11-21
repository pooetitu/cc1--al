package com.al.kernel;

public class ConsoleLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println("[INFO]: " + message);
    }

    @Override
    public void error(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
