package com.baloise.jenkinslibrary.demo;

import static org.assertj.core.api.Assertions.assertThat

import org.junit.Before
import org.junit.Test

import com.baloise.jenkinslibrary.JenkinsMock
import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.demo.internal.GreetingImpl


class GreetingTest {
	
	Greeting greeting
	def mockedJenkins

	@Before
	void setUp() {
		mockedJenkins = JenkinsMock.create()
		greeting = new GreetingImpl(mockedJenkins)
	}

	@Test
	void greeting_sayHello_when_name_is_world_then_greeting_is_Hello_World() {
		String actual = greeting.greet("World")
		assertThat(actual).isEqualTo("¡Hola World!")
	}

}
