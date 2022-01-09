package com.al.cc2.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command) throws Exception;
}
