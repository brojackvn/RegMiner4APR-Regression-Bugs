/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.hateoas;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Integration tests for {@link RepresentationModel}.
 *
 * @author Oliver Gierke
 */
class RepresentationModelIntegrationTest extends AbstractJackson2MarshallingIntegrationTest {

	static final String REFERENCE = "{\"links\":[{\"rel\":\"self\",\"href\":\"localhost\"}]}";

	@Test // #7
	void doesNotRenderId() throws Exception {

		RepresentationModel<?> model = new RepresentationModel<>();
		model.add(new Link("localhost"));

		assertThat(write(model)).isEqualTo(REFERENCE);
	}

	@Test // #14
	void readResourceSupportCorrectly() throws Exception {

		RepresentationModel<?> model = read(REFERENCE, RepresentationModel.class);

		assertThat(model.getLinks()).hasSize(1);
		assertThat(model.getLinks()).contains(new Link("localhost"));
	}
}
