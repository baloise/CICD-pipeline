package com.baloise.sharedlib.demo.internal

import com.baloise.sharedlib.common.Registered
import com.baloise.sharedlib.demo.Greeting

class GreetingImpl extends Registered implements Greeting, Serializable {
	
    String greet(String name = "Nobody") {
		if(name) name = " ${name}"
		return "¡Hola${name}!"
    }
}
