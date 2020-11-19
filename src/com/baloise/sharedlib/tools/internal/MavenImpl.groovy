package com.baloise.sharedlib.tools.internal

import com.baloise.sharedlib.common.Registered
import com.baloise.sharedlib.tools.Maven

class MavenImpl extends Registered implements Maven{

	@Override
	public void mvn(String cmd, String mavenVersion = Maven.MAVEN_VERSION_DEFAULT, String jdkVersion = "nope") {
		// TODO 
		// this is a fake-it-until-you-make-it
		// shall we use https://hub.docker.com/_/maven ?
		if(steps.isUnix()) {
			steps.withEnv(["M2_HOME=/opt/maven", "PATH=/opt/maven/bin:/sbin:/usr/sbin:/bin:/usr/bin"]) {
				steps.sh "mvn $cmd"
			}
		} else {
			steps.bat "mvn $cmd"
		}
	}
}