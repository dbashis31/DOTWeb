package com.dot.config;

import java.util.Properties;
import java.util.Properties;

import javax.sql.DataSource;
 


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan({ "com.dot.*" })
@Import({ SecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
    private Environment environment;

	/*@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
	    driverManagerDataSource.setUrl("jdbc:derby:C:\\workscope\\DOT\\DOT;create=false");
	    driverManagerDataSource.setUsername("dot");
	    driverManagerDataSource.setPassword("dot");
	    return driverManagerDataSource;
	}*/
	
	/*@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.dot.data" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }*/
     
	@Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("-==================="+environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
     
   /* private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }*/
     
   /* @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }*/
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	       
	    }
	 
	 @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("login");
	  }
	 
	 /*@Override
	 public void configureMessageConverters(List<HttpMessageConverter < ? >> converters) {
		    MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
	        converters.add(converter);
	  
	   }*/
	   /* @Bean
	    public RequestMappingHandlerAdapter  annotationMethodHandlerAdapter()
	    {
	        final RequestMappingHandlerAdapter annotationMethodHandlerAdapter = new RequestMappingHandlerAdapter();
	        final MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();

	        List<HttpMessageConverter<?>> httpMessageConverter = new ArrayList<HttpMessageConverter<?>>();
	        httpMessageConverter.add(mappingJacksonHttpMessageConverter);

	        String[] supportedHttpMethods = { "POST", "GET", "HEAD" };

	        annotationMethodHandlerAdapter.setMessageConverters(httpMessageConverter);
	        annotationMethodHandlerAdapter.setSupportedMethods(supportedHttpMethods);

	        return annotationMethodHandlerAdapter;
	    }*/
	 
	 @Bean
	  public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(8192);
	    multipartResolver.setDefaultEncoding("utf-8");
	    return multipartResolver;
	  }
	
}