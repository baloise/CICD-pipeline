import com.baloise.sharedlib.common.Registry
import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.tools.Maven

def call(String cmd, String tag = "") {
	new Registry(this).getService(Maven.class).mvn(cmd, tag)
}