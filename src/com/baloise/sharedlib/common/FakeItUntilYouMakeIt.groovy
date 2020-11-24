package com.baloise.sharedlib.common

@Deprecated
class FakeItUntilYouMakeIt {
	Registered registered
	static FakeItUntilYouMakeIt fake(Registered registered) {new FakeItUntilYouMakeIt(registered: registered)}
	
	/**
	 *  this is a hack for development and not supported in production,
	 *	see 
	 *  	https://github.com/baloise/CICD-pipeline/blob/main/docs/decisions/004-depend-on-linux.md
	 *  	https://github.com/baloise/CICD-pipeline/blob/main/docs/decisions/006-homogeneous-build-across-environments.md
	 *      https://github.com/baloise/CICD-pipeline/issues/34
	 */
	boolean isWindows() {
		!registered.steps.isUnix()
	}
}
