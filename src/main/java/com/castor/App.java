package com.castor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

//@RestController  //返回json字符串的数据，直接可以编写RESTFul的接口；
@SpringBootApplication  //申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
@ServletComponentScan//是的spring能够扫描到我们自己编写的关于druid的servlet和filter。
public class App {

	@RequestMapping("/")  
    public String hello(){  
      return "Hello world!";  
    }  
	
	/**
	 * springboot 引入 fastjson 的方式一
	 * 
	 * 方式二：
	 * @SpringBootApplication  
		public class App  extends WebMvcConfigurerAdapter {  
     
	    @Override  
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {  
	        super.configureMessageConverters(converters);  
	        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();  
	        FastJsonConfig fastJsonConfig = new FastJsonConfig();  
	        fastJsonConfig.setSerializerFeatures(  
	                SerializerFeature.PrettyFormat  
	        );  
	        fastConverter.setFastJsonConfig(fastJsonConfig);  	        
	        converters.add(fastConverter);  
	    }  
	 }  
	 * @return
	 */
	@Bean  
    public HttpMessageConverters fastJsonHttpMessageConverters() {  
       FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();  
       FastJsonConfig fastJsonConfig = new FastJsonConfig();  
       fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);  
       fastConverter.setFastJsonConfig(fastJsonConfig);  
       HttpMessageConverter<?> converter = fastConverter;  
       return new HttpMessageConverters(converter);  
    }  
	
	
	
	
	public static void main(String[] args) {
		/**
		 * 运行我们的Application了，
		 * 第一种方式特别简单：右键Run As -> Java Application。之后打开浏览器输入地址：http://127.0.0.1:8080/ 就可以看到Hello world!了。
		 * 第二种方式右键project – Run as – Maven build – 在Goals里输入spring-boot:run ,然后Apply,最后点击Run。
		 */
		SpringApplication.run(App.class, args);  
	}

}
