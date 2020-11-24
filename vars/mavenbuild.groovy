def call(input) {
    if (!input) {
        input = [:]
    }

	String tag = ''
	switch (email) {
		case ~/.*openJDK.*/:
		   tag = '3-openjdk-11' 
		  break
		case ~/.*oracle.*/:
			error "need to provide oracle container" 
	}
	if(input.uploadArtifactsWithBranchnameInVersion) error "not yet implemented"
	
	mvn("${input.mavenArgs?:''} $input.cmd")
	
}

