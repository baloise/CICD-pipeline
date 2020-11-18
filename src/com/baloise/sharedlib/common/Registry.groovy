package com.baloise.sharedlib.common

import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.demo.internal.GreetingImpl
import com.cloudbees.groovy.cps.NonCPS

class Registry {

    Map serviceRegistry = [:]
    def steps
	
	Registry(steps) {
        this.steps = steps
        registerService(Greeting.class, new GreetingImpl(registry: this))
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
