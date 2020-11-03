import com.baloise.sharedlib.common.Registry
import com.baloise.sharedlib.demo.Greeting

def call(String name) {
	call([name : name])
}
def call(Map input) {
	input = input ?: [:]
    Registry registry = new Registry(this)
    Greeting greeting = registry.getService(Greeting.class)
    greeting.greet(input.name)
}
