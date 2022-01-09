package com.al.cc2.kernel;

import java.util.Map;

public class DefaultQueryBus implements QueryBus {
    private final Map<Class<? extends Query>, QueryHandler> dataMap;

    public DefaultQueryBus(Map<Class<? extends Query>, QueryHandler> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public <Q extends Query, R> R send(Q query) {
        return dispatch(query);
    }

    private <Q extends Query, R> R dispatch(Q query) {
        final QueryHandler queryHandler = dataMap.get(query.getClass());
        if (queryHandler == null) {
            throw new RuntimeException("No such query handler for " + query.getClass().getName());
        }

        return (R) queryHandler.handle(query);
    }
}
