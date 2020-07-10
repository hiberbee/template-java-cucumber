package com.hiberbee.configurations;

import com.hiberbee.Application;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationConfiguration {

  @Bean
  public CacheManager cacheManager() {
    return new ConcurrentMapCacheManager("cucumber");
  }
}
