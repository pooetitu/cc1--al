package com.al.cc2.kernel;

public interface EventListener<E extends Event> {
    void listen(E event);
}
