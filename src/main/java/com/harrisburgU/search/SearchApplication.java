package com.harrisburgU.search;

import com.harrisburgU.search.controller.SearchPlacesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = SearchApplication.class)
public class SearchApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SearchApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();

		//Arrays.sort(beanNames);
//
//		for (String beanName : beanNames){
//			System.out.println(beanName);
//		}
	}

}
