package com.blacamdk.template.config;

import com.blacamdk.template.interceptor.MyInterceptor;
import com.blacamdk.template.utils.GsonUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebApplicationConfig.class);

  @Autowired private MyInterceptor myInterceptor;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    /*
        registry
            .addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/")
            .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
    */
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(myInterceptor).addPathPatterns("/**");
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
    stringConverter.setWriteAcceptCharset(false);
    stringConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
    converters.add(stringConverter);
    converters.add(new ByteArrayHttpMessageConverter());
    converters.add(new SourceHttpMessageConverter<>());
    GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
    gsonHttpMessageConverter.setGson(gson());
    gsonHttpMessageConverter.setSupportedMediaTypes(
        Collections.singletonList(MediaType.APPLICATION_JSON));
    converters.add(gsonHttpMessageConverter);
  }

  @Bean
  public Gson gson() {
    return GsonUtils.getCommonGsonBuilder().create();
  }

  /**
   * 跨越配置
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .maxAge(3600)
        .allowCredentials(true);
  }
}
