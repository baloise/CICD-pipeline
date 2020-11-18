package com.baloise.sharedlib.common


// yes, I know ... composition over inheritance, 
// but traits don't work in Jenkins (https://issues.jenkins.io/browse/JENKINS-46145) 
// and Mixins are deprecated (http://docs.groovy-lang.org/latest/html/api/groovy/lang/Mixin.html)
abstract class Registered {
	Registry registry
	def steps
}
