/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.template.soy.shared.restricted;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * Binding annotations related to the ApiCallScope.
 *
 * <p>Important: This class may only be used in implementing plugins (e.g. functions, directives).
 *
 */
public class ApiCallScopeBindingAnnotations {

  private ApiCallScopeBindingAnnotations() {}

  /**
   * Annotation for the localeString parameter in the ApiCallScope.
   *
   * @deprecated Don't inject this, instead migrate to SoyJavaSourceFunction and access the Locale
   *     from the context object.
   */
  @Qualifier
  @Target({FIELD, PARAMETER, METHOD})
  @Retention(RUNTIME)
  @Deprecated
  public @interface LocaleString {}
}