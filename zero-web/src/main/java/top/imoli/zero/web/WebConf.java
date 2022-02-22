package top.imoli.zero.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.imoli.zero.web.response.JsonHttpMessageConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@Configuration
public class WebConf implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				//HttpContext.addHttp(request, response);
				return true;
			}
		});
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*").exposedHeaders("Content-Disposition");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.removeIf(c -> c.getClass().equals(MappingJackson2HttpMessageConverter.class));
		JsonHttpMessageConverter fastConverter = new JsonHttpMessageConverter();
		// 2、添加fastjson的配置信息，比如 是否要格式化返回json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.QuoteFieldNames, SerializerFeature.DisableCircularReferenceDetect);
		// 3、在convert中添加配置信息.
		fastConverter.setFastJsonConfig(fastJsonConfig);
		fastConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
		// 4、将convert添加到converters当中.
		converters.add(fastConverter);
	}
}
