package com.ithzk.cross;

import com.ithzk.cross.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class CrossDomainServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossDomainServerApplication.class, args);
	}

	/**
	 * 注册过滤器
	 * @return
	 */
	/*@Bean
	public FilterRegistrationBean registrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.addUrlPatterns("*//*");
		filterRegistrationBean.setFilter(new CorsFilter());
		return filterRegistrationBean;
	}*/
}
