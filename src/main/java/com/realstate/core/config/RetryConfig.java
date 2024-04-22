package com.realstate.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * Configuration class for setting up retry operations in the application. This class
 * defines a RetryOperationsInterceptor bean with custom retry and backoff policies.
 * Author: [Aashish Karki]
 */
@Configuration
@EnableRetry
public class RetryConfig {

  @Value("${retry.maxAttempts}")
  private Integer maxRetry;

  @Bean(name = "retryInterceptor")
  public RetryOperationsInterceptor retryInterceptor() {
    RetryTemplate retryTemplate = new RetryTemplate();

    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(maxRetry);

    ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
    exponentialBackOffPolicy.setInitialInterval(500);
    exponentialBackOffPolicy.setMultiplier(2);

    retryTemplate.setRetryPolicy(retryPolicy);
    retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);

    return RetryInterceptorBuilder.stateless().retryOperations(retryTemplate).build();
  }
}
