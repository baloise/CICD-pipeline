package com.baloise.jenkinslibrary.demo;

import static org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import com.baloise.jenkinslibrary.JenkinsMock
import com.baloise.sharedlib.common.Registry
import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.demo.internal.GreetingImpl


class GreetingTest {
	
	GreetingTest() {}
	
	Greeting greeting

	@BeforeEach
	void setUp() {
		greeting = new GreetingImpl(registry:new Registry(JenkinsMock.create()))
	}

	@Test
	void greeting_sayHello_when_name_is_world_then_greeting_is_Hello_World() {
		assertThat(greeting.greet("World")).isEqualTo("¡Hola World!")
	}
	
	@Test
	void greeting_sayHello_when_name_is_null_then_greeting_is_fall_back_to_nobody() {
		assertThat(greeting.greet()).isEqualTo("¡Hola Nobody!")
	}
	
	@Test
	void greeting_sayHello_when_name_is_empty() {
		assertThat(greeting.greet("")).isEqualTo("¡Hola!")
	}

}
