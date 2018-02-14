package com.olonte.softipac.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.olonte.softipac.convertidor.RegistroDiagnosticoPaciente;
import com.olonte.softipac.convertidor.RegistroRolUsuario;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ("com.olonte.softipac"))
public class WebApplicationContextConfiguration extends WebMvcConfigurerAdapter {
	
	private RegistroRolUsuario registroRolUsuario;
	private RegistroDiagnosticoPaciente registroDiagnosticoPaciente;
	
	private String prefix            = "/WEB-INF/views/";
	private String suffix			 = ".jsp";
	private String pathPatterns      = "/static/*";
	private String resourceLocations = "/static/";
	private String basename          = "messages";
	
	
	@Autowired
	public WebApplicationContextConfiguration(RegistroRolUsuario registroRolUsuario,
			RegistroDiagnosticoPaciente registroDiagnosticoPaciente) {
		this.registroRolUsuario = registroRolUsuario;
		this.registroDiagnosticoPaciente = registroDiagnosticoPaciente;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(pathPatterns).addResourceLocations(resourceLocations);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(registroRolUsuario);
		registry.addConverter(registroDiagnosticoPaciente);
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
	
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new Hibernate5Module());
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
		return mappingJackson2HttpMessageConverter;
	}

}
