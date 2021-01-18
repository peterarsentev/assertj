/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2021 the original author or authors.
 */
package org.assertj.core.error;

import static java.lang.String.format;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldBeFinite.shouldBeFinite;
import static org.assertj.core.presentation.StandardRepresentation.STANDARD_REPRESENTATION;

import org.assertj.core.internal.TestDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ShouldBeFinite create")
class ShouldBeFinite_create_Test {

  @Test
  void should_create_error_message_with_double() {
    // GIVEN
    Double actual = Double.POSITIVE_INFINITY;
    // WHEN
    String message = shouldBeFinite(actual).create(new TestDescription("TEST"), STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo(format("[TEST] %nExpecting Infinity to be finite"));
  }

  @Test
  void should_create_error_message_with_float() {
    // GIVEN
    float actual = Float.POSITIVE_INFINITY;
    // WHEN
    String message = shouldBeFinite(actual).create(new TestDescription("TEST"), STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo(format("[TEST] %nExpecting Infinityf to be finite"));
  }
}
