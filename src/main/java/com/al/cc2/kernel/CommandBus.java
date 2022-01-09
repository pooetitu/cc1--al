package com.al.cc2.kernel;

public interface CommandBus {
    <C extends Command, R> R send(C command) throws Exception;
}
