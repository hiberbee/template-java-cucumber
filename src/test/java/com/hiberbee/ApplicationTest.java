package com.hiberbee;

import com.hiberbee.configurations.ApplicationConfiguration;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@Cucumber
@SpringBootTest(
    classes = ApplicationConfiguration.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApplicationTest {

  @Test
  void testMain() {}
}
