package com.cts.product.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@PropertySource("db.properties")
@ComponentScans( value= {@ComponentScan("com.cts.product.service"), @ComponentScan("com.cts.product.dao")})
public class AppConfig {

	@Autowired
	private Environment environment;

	// Data Source

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("url"));
		driverManagerDataSource.setUsername(environment.getProperty("user-name"));
		driverManagerDataSource.setPassword(environment.getProperty("password"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("driver-class"));
		return driverManagerDataSource;

	}

	// JDBC Template

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}

	// Connection pool like dbcp2

	// transaction manager

	public JtaTransactionManager getTransaction() {

		JtaTransactionManager jm = new JtaTransactionManager();
		// jm.setTransactionManager(getJdbcTemplate());

		return null;

	}

}
