package com.baloise.sharedlib.tools;

interface Maven {
	
	// TODO should we use a global variables class ( fed by jenkins config ? )
	String MAVEN_VERSION_DEFAULT = "LATEST"
	
    void mvn(String cmd, String mavenVersion, String jdkVersion)
}
