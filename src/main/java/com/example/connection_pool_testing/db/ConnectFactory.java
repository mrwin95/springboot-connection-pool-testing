package com.example.connection_pool_testing.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectFactory {

    private final DirectConnectionStrategy directConnectionStrategy;
    private final PooledConnectStrategy pooledConnectStrategy;

    @Value("${database.connection.pooling:true}")
    private boolean usePooling;

    @Autowired
    public ConnectFactory(DirectConnectionStrategy directConnectionStrategy,
            PooledConnectStrategy pooledConnectStrategy) {
        this.directConnectionStrategy = directConnectionStrategy;
        this.pooledConnectStrategy = pooledConnectStrategy;
    }

    public ConnectionStrategy gConnectionStrategy() {
        return usePooling ? pooledConnectStrategy : directConnectionStrategy;
    }

}
