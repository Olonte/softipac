package com.olonte.softipac.bd;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = ("com.olonte.softipac"))
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = ("com.olonte.softipac.repositorio"))
@EnableTransactionManagement
public class JPAConfiguration {
	
	@Autowired
	private Environment environment;
	
	private static final boolean SHOW_SQL = true;

	private String packagesToScan    = "com.olonte.softipac.modelo";
	private String hbDialect		 = "hibernate.dialect";
	private String hbShowSql         = "hibernate.show_sql";
	private String hbFormatSql       = "hibernate.format_sql";
	private String hbConncharSet     = "hibernate.connection.charSet";	
	private String hbCurrSessContxCl = "hibernate.current_session_context_class";
	private String hbArchAutodect    = "hibernate.archive.autodetection";
	private String hbCacheSecLev     = "hibernate.cache.use_second_level_cache";
	private String hbCacheProvCl     = "hibernate.cache.provider_class";
	private String hbCacheRegFaCl    = "hibernate.cache.region.factory_class";
	private String orghbEhCacheConf  = "org.hibernate.ehcache.configurationResourceName";
	private String hbImplNamSt       = "hibernate.implicit_naming_strategy";
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
		driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.url"));
		driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.username"));
		driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaDialect(jpaDialect());
		localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);
		localContainerEntityManagerFactoryBean.setMappingResources();
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setShowSql(SHOW_SQL);
		hibernateJpaVendorAdapter.setDatabasePlatform(environment.getProperty("spring.jpa.dialect"));
		return hibernateJpaVendorAdapter;
	}
	
	@Bean
	public JpaDialect jpaDialect() {
		JpaDialect jpaDialect = new HibernateJpaDialect();
		return jpaDialect;
	}
	
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put(hbDialect, environment.getRequiredProperty("spring.jpa.dialect"));
		properties.put(hbShowSql, environment.getRequiredProperty("spring.jpa.show_sql"));
		properties.put(hbFormatSql, environment.getRequiredProperty("spring.jpa.format_sql"));
		properties.put(hbConncharSet, environment.getRequiredProperty("spring.jpa.connection.charset"));
		properties.put(hbCurrSessContxCl, environment.getRequiredProperty("spring.jpa.currentSessionContextClass"));
		properties.put(hbArchAutodect, environment.getRequiredProperty("spring.jpa.autodetection"));
		properties.put(hbCacheSecLev, environment.getProperty("spring.hibernate.cache.use_second_level_cache"));
		properties.put(hbCacheProvCl, environment.getProperty("spring.hibernate.cache.provider_class"));
		properties.put(hbCacheRegFaCl, environment.getRequiredProperty("spring.hibernate.ecache_region_factory"));
		properties.put(orghbEhCacheConf, environment.getRequiredProperty("spring.hibernate.ecached.config_res_name"));
		properties.put(hbImplNamSt, environment.getRequiredProperty("spring.hibernate.implicit_naming_strategy"));
		return properties;
	}

}
