package com.hiberbee.cucumber.definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.*;

@CacheConfig(cacheNames = "cucumber")
public class SampleStepDefinitions {

  private final ObjectMapper objectMapper;

  @Value("#{cacheManager.getCache('cucumber')}")
  private Cache cache;

  public SampleStepDefinitions(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Given("simple step")
  public void stepExample() {
    Assertions.assertThat(true).isTrue();
  }

  @Given("step with parameter {string}")
  public void stepExampleWithParameter(final String parameter) {
    Assertions.assertThat(parameter).isNotEmpty();
  }

  @Given("step with autowired bean dependency")
  public void stepExampleWithBeanDependency() {
    Assertions.assertThat(this.objectMapper).isInstanceOf(ObjectMapper.class);
  }

  @Given("step returns {string} example")
  @CachePut(key = "#root.methodName")
  public String stepReturnsExample(final String value) {
    return value;
  }

  @Given("step result {string} assertion example")
  public void stepValuePersistenceExample(final String value) {
    Assertions.assertThat(this.cache.get("stepReturnsExample", String.class)).isEqualTo(value);
  }
}
