import com.baloise.sharedlib.common.Registry
import com.baloise.sharedlib.demo.Greeting

def call(input) {
    if (!input) {
        input = [:]
    }
    Registry registry = new Registry(this)
    Greeting greeting = registry.getService(Greeting.class)
    greeting.sayHello(input.name)
}
