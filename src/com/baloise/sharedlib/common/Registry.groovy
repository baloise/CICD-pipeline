package com.baloise.sharedlib.common

import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.demo.internal.GreetingImpl
import com.cloudbees.groovy.cps.NonCPS

class Registry {

    def serviceRegistry = new HashMap()
    def steps

    Registry(steps) {
        this.steps = steps
        registerService(Greeting.class, new GreetingImpl(this))
    }

    @NonCPS
    private <T> void registerService(Class<T> serviceClazz, T impl) {
        serviceRegistry.put(serviceClazz, impl)
    }

    @NonCPS
    <T> T getService(Class<T> serviceClazz) {
        return (T) this.serviceRegistry.get(serviceClazz)
    }
}
