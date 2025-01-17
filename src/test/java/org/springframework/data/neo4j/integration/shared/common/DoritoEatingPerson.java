/*
 * Copyright 2011-2023 the original author or authors.
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
package org.springframework.data.neo4j.integration.shared.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * @author Michael J. Simons
 */
@Data
@ToString(exclude = { "friends" })
@Node
@NoArgsConstructor
@AllArgsConstructor
public class DoritoEatingPerson {

	@Id
	private long id;

	@Property
	private String name;

	@Property
	private boolean eatsDoritos;

	@Property
	private boolean friendsAlsoEatDoritos;

	@Relationship
	private Set<DoritoEatingPerson> friends = new HashSet<>();

	public DoritoEatingPerson(String name) {
		this.name = name;
	}

	/**
	 * Projection containing ambiguous name
	 */
	public interface PropertiesProjection1 {

		boolean getEatsDoritos();

		boolean getFriendsAlsoEatDoritos();
	}

	/**
	 * Projection not containing ambiguous name
	 */
	public interface PropertiesProjection2 {

		boolean getEatsDoritos();
	}
}
