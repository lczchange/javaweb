package com.lcz.spring_tx.test;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TrasantionManagerConfiguration {

    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransaction(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
