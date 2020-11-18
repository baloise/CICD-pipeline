import com.baloise.sharedlib.common.Registry
import com.baloise.sharedlib.demo.Greeting
import com.baloise.sharedlib.tools.Maven

def call(String cmd, String mavenVersion = Maven.MAVEN_VERSION_DEFAULT, String jdkVersion = "nope") {
	new Registry(this).getService(Maven.class).mvn(cmd, mavenVersion, jdkVersion)
}