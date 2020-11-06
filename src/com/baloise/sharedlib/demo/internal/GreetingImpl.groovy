package com.baloise.sharedlib.demo.internal

import com.baloise.sharedlib.demo.Greeting

class GreetingImpl implements Greeting {

    def steps

    GreetingImpl(steps) {
        this.steps = steps
    }

    String greet(String name = "Nobody") {
		if(name) name = " ${name}"
		return "¡Hola${name}!"
    }
}
