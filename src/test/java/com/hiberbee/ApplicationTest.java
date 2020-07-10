package com.hiberbee;

import com.hiberbee.configurations.ApplicationConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = ApplicationConfiguration.class)
public class ApplicationTest {

  @Test
  void testMain() {}
}