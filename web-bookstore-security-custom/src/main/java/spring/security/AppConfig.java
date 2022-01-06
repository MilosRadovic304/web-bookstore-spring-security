package spring.security;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration // because it is a configuration class
@EnableWebMvc //provides similar support to <mvc:annotation-driven>
@EnableTransactionManagement //adds transaction manager support
@ComponentScan("spring") //which packages to scan to find controllers, services, DAO, entity 
@PropertySource({"classpath:persistence-oracle.properties", "classpath:persistence-oracle.properties"}) //this is used to read values from properties file
public class AppConfig  implements WebMvcConfigurer{

	
	
	@Autowired
	private Environment env; //set up variable to hold the data read from the properties file
	
	//set up a logger for diagnostics
	//private Logger logger = logger.getLogger(getClass().getName());
	
	
	// define a bean for View Resolver
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("fancy-login");
	  }
	
	
	@Bean
	public DataSource myDataSource() { // create bean for DataSource
		
		// create connection pool -from c3p0 framework
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));	//read data from properties file	//"oracle.jdbc.driver.OracleDriver"
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// to check if we are reading data from properties file
		//logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		//logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection props
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}
	
	
	// need a helper method
	//read environment property and convert to int
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		//now convert to int
		int intPropVal = Integer.parseInt(propVal);
			
		
		return intPropVal;			
	}
	
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factories 
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }	
	
}
