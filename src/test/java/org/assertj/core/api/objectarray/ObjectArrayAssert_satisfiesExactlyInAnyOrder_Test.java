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
package org.assertj.core.api.objectarray;

import static org.assertj.core.test.ObjectArrays.arrayOf;
import static org.assertj.core.util.Lists.list;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.function.Consumer;

import org.assertj.core.api.ObjectArrayAssert;
import org.assertj.core.api.ObjectArrayAssertBaseTest;

/**
 * Tests for <code>{@link ObjectArrayAssert#satisfiesExactlyInAnyOrder(Consumer...)}</code>.
 *
 * @author Michael Grafl
 */
class ObjectArrayAssert_satisfiesExactlyInAnyOrder_Test extends ObjectArrayAssertBaseTest {

  private Consumer<Object> consumer = mock(Consumer.class);

  @Override
  protected ObjectArrayAssert<Object> create_assertions() {
    return new ObjectArrayAssert<>(arrayOf(new Object()));
  }

  @Override
  protected ObjectArrayAssert<Object> invoke_api_method() {
    return assertions.satisfiesExactlyInAnyOrder(consumer);
  }

  @Override
  protected void verify_internal_effects() {
    verify(iterables).assertSatisfiesExactlyInAnyOrder(getInfo(assertions), list(getActual(assertions)), consumer);
  }
}
