package com.fashionShop.config;

import org.springframework.boot.SpringBootConfiguration;
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
	        
	        //detailProduct
	        
	        registry.addResourceHandler("/detailProduct/fonts/**")
            .addResourceLocations("/WEB-INF/fonts/");

		    registry.addResourceHandler("/detailProduct/css/**")
		            .addResourceLocations("/WEB-INF/css/");
		
		    registry.addResourceHandler("/detailProduct/js/**")
		            .addResourceLocations("/WEB-INF/js/");
		    	
		    registry.addResourceHandler("/detailProduct/img/**")
		    		.addResourceLocations("/WEB-INF/img/");
		    
		    registry.addResourceHandler("/detailProduct/sass/**")
		    		.addResourceLocations("/WEB-INF/sass/");
		    
		    registry.addResourceHandler("/detailProduct/Source/**")
		    		.addResourceLocations("/WEB-INF/Source/");
	        //cart
	        
	        registry.addResourceHandler("/cart/fonts/**")
            .addResourceLocations("/WEB-INF/fonts/");

		    registry.addResourceHandler("/cart/css/**")
		            .addResourceLocations("/WEB-INF/css/");
		
		    registry.addResourceHandler("/cart/js/**")
		            .addResourceLocations("/WEB-INF/js/");
		    	
		    registry.addResourceHandler("/cart/img/**")
		    		.addResourceLocations("/WEB-INF/img/");
		    
		    registry.addResourceHandler("/cart/sass/**")
		    		.addResourceLocations("/WEB-INF/sass/");
		    
		    registry.addResourceHandler("/cart/Source/**")
		    		.addResourceLocations("/WEB-INF/Source/");
	        
		    
	        //delete
	        
	        registry.addResourceHandler("/cart/delete/fonts/**")
            .addResourceLocations("/WEB-INF/fonts/");

		    registry.addResourceHandler("/cart/delete/css/**")
		            .addResourceLocations("/WEB-INF/css/");
		
		    registry.addResourceHandler("/cart/delete/js/**")
		            .addResourceLocations("/WEB-INF/js/");
		    	
		    registry.addResourceHandler("/cart/delete/img/**")
		    		.addResourceLocations("/WEB-INF/img/");
		    
		    registry.addResourceHandler("/cart/delete/sass/**")
		    		.addResourceLocations("/WEB-INF/sass/");
		    
		    registry.addResourceHandler("/cart/delete/Source/**")
		    		.addResourceLocations("/WEB-INF/Source/");
	      
		    
		    //add
	        
	        registry.addResourceHandler("/cart/add/fonts/**")
            .addResourceLocations("/WEB-INF/fonts/");

		    registry.addResourceHandler("/cart/add/css/**")
		            .addResourceLocations("/WEB-INF/css/");
		
		    registry.addResourceHandler("/cart/add/js/**")
		            .addResourceLocations("/WEB-INF/js/");
		    	
		    registry.addResourceHandler("/cart/add/img/**")
		    		.addResourceLocations("/WEB-INF/img/");
		    
		    registry.addResourceHandler("/cart/add/sass/**")
		    		.addResourceLocations("/WEB-INF/sass/");
		    
		    registry.addResourceHandler("/cart/add/Source/**")
		    		.addResourceLocations("/WEB-INF/Source/");
	    }	
		
		
}