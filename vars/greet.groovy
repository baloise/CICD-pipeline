import com.baloise.sharedlib.common.Registry
import com.baloise.sharedlib.demo.Greeting

def call(String name = "Nobody") {
	new Registry(this).getService(Greeting.class).greet(name)
}
