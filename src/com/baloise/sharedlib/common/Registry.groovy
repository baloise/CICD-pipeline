package com.baloise.sharedlib.common

import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.demo.internal.GreetingImpl
import com.baloise.sharedlib.tools.Maven
import com.baloise.sharedlib.tools.internal.MavenImpl
import com.cloudbees.groovy.cps.NonCPS

class Registry {

    Map serviceRegistry = [:]
	
	Registry(steps) {
        registerService(Greeting.class, new GreetingImpl(registry: this, steps: steps))
        registerService(Maven.class, new MavenImpl(registry: this, steps: steps))
    }

    @NonCPS
    private <T> void registerService(Class<T> serviceClazz, T impl) {
        serviceRegistry[serviceClazz] =  impl
    }

    @NonCPS
    <T> T getService(Class<T> serviceClazz) {
        serviceRegistry[serviceClazz]
    }
}
