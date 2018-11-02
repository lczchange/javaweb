package com.lcz.spring_tx.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.lcz.spring_tx")
@EnableTransactionManagement
@Import({DatasourceConfiguration.class,TrasantionManagerConfiguration.class})
public class SpringConfiguration {
}
