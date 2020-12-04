package com.baloise.coverage;

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test


class ReadmeTest {
	
	@Test
	void branchNameMustBeInCoverageLink() {
		File HEAD = new File(".git/HEAD")
		if(!HEAD.exists()) return
		String branch = new File(".git/HEAD").text.split('/')[-1].trim()
		int c = 3
		assertEquals(c, new File("README.md").text.count("/CICD-pipeline/site/$branch/"), "occurences of /CICD-pipeline/site/$branch/") 
	}
	
}
