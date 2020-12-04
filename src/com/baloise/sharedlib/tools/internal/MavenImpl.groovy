package com.baloise.sharedlib.tools.internal

import static com.baloise.sharedlib.common.FakeItUntilYouMakeIt.fake

import java.nio.file.*

import com.baloise.sharedlib.common.FakeItUntilYouMakeIt
import com.baloise.sharedlib.common.Registered
import com.baloise.sharedlib.tools.Maven

class MavenImpl extends Registered implements Maven, Serializable{

	@Override
	// tag see https://hub.docker.com/_/maven
	public void mvn(String cmd, String tag = "") {
		String image = tag ? "maven:$tag" : "maven"
		if(fake(this).isWindows()) {
			String sname = "docker-settings.xml"
			String settings = 
			Files.exists(Paths.get(System.getProperty("user.home"), '.m2').toRealPath().resolve(sname)) ? 
				"-s /root/.m2/$sname" : 
				""
				steps.bat "docker run --rm -v \"%cd%\":/usr/src/mymaven -v \"%userprofile%\\.m2\":/root/.m2 -w /usr/src/mymaven $image mvn $settings $cmd"
		} else {
			steps.docker.image(image).inside('-v $HOME/.m2:/root/.m2') {
				steps.sh "mvn $cmd"
			}
		}
	}
}
