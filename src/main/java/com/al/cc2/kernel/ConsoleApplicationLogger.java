package com.al.cc2.kernel;

import java.util.logging.Logger;


public class ConsoleApplicationLogger implements ApplicationLogger {
    private static final Logger logger = Logger.getLogger("ConsoleApplicationLogger");

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void warning(String message) {
        logger.warning(message);
    }
}
