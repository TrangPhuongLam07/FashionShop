package com.fashionShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.fashionShop.controller")
public class FashionShopConfiguration implements WebMvcConfigurer{
	//set up view resolver
		@Bean
		public InternalResourceViewResolver viewResolver() {
			
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			
			return viewResolver;
		}
		
		// =======================================
	    // =          Override Methods           =
	    // =======================================
		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/fonts/**")
	                .addResourceLocations("/WEB-INF/fonts/");

	        registry.addResourceHandler("/css/**")
	                .addResourceLocations("/WEB-INF/css/");

	        registry.addResourceHandler("/js/**")
	                .addResourceLocations("/WEB-INF/js/");
	        	
	        registry.addResourceHandler("/img/**")
            .addResourceLocations("/WEB-INF/img/");
	        
	        registry.addResourceHandler("/sass/**")
            .addResourceLocations("/WEB-INF/sass/");
	        
	        registry.addResourceHandler("/Source/**")
            .addResourceLocations("/WEB-INF/Source/");
	        
	      
	    }		
}