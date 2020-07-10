package com.hiberbee;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

  public static void main(final String[] args) {
    new SpringApplicationBuilder().sources(Application.class).run(args);
  }
}
