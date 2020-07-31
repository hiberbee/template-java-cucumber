/*
 * MIT License
 *
 * Copyright (c) 2020 Hiberbee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.hiberbee.cucumber.definitions;

import dev.hiberbee.configurations.ApplicationConfiguration;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootTest(classes = {ApplicationConfiguration.class, SampleSteps.class})
class SampleStepsTest {

  @Value("#{cacheManager.getCache('cucumber')}")
  private Cache cache;

  @Autowired private SampleSteps sampleSteps;

  @Test
  void testStepExample() {
    this.sampleSteps.stepExample();
  }

  @Test
  void testStepExampleWithParameter() {
    this.sampleSteps.stepExampleWithParameter("Something");
  }

  @Test
  void testStepExampleWithBeanDependency() {
    this.sampleSteps.stepExampleWithBeanDependency();
  }

  @Test
  void testStepReturnsExample() {
    final var expected = "test";
    final var actual = this.sampleSteps.stepReturnsExample(expected);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void testValuePersistenceExample() {
    this.sampleSteps.stepValuePersistenceExample(this.sampleSteps.stepReturnsExample("test"));
  }
}
