package com.olonte.softipac.configuracion;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ("com.olonte.softipac"))
public class WebApplicationContextConfiguration extends WebMvcConfigurerAdapter {
	
	private String prefix            = "/WEB-INF/views/";
	private String suffix			 = ".jsp";
	private String pathPatterns      = "/static/*";
	private String resourceLocations = "/static/";
	private String basename          = "messages";

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(pathPatterns).addResourceLocations(resourceLocations);
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix(prefix);
		internalResourceViewResolver.setSuffix(suffix);
		return internalResourceViewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename(basename);
		return resourceBundleMessageSource;
	}

}
