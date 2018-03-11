package com.castor.base.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{

	/**
	 * 访问castor 文件夹中的test.jpg 图片的地址为 http://localhost:8080/castor/test.jpg 
		这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
		如果我们将/castor/* 修改为 /* 与默认的相同时，则会覆盖系统的配置，可以多次使用 addResourceLocations 添加目录，优先级先添加的高于后添加的。      
		其中 addResourceLocations 的参数是动参，可以这样写 addResourceLocations(“classpath:/img1/”, “classpath:/img2/”, “classpath:/img3/”);
		使用外部目录
		如果我们要指定一个绝对路径的文件夹（如 D:/data/api_files ），则只需要使用 addResourceLocations 指定即可。		
		// 可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上file:		
		registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/data/api_files");
	 
	 `默认情况下：
	 	其中默认配置的 /** 映射到 /static （或/public、/resources、/META-INF/resources） 
		其中默认配置的 /webjars/** 映射到 classpath:/META-INF/resources/webjars/ 
		PS：上面的 static、public、resources 等目录都在 classpath: 下面（如 src/main/resources/static）。
	           当我们访问地址 http://localhost:8080/test.jpg 的时候，显示哪张图片？
	           这里可以直接告诉大家，优先级顺序为：META/resources > resources > static > public  (已进行测试)
	 *
	 */	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/castor/**").addResourceLocations("classpath:/castor/");
		super.addResourceHandlers(registry);
	}

}
