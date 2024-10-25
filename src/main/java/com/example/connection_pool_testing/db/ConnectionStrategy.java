package com.example.connection_pool_testing.db;

import javax.sql.DataSource;

public interface ConnectionStrategy {
    DataSource getDataSource();
}
