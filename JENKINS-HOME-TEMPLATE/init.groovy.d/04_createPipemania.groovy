import jenkins.model.*
import hudson.*
import hudson.model.*
import java.util.logging.Logger
Logger log = Logger.getLogger('init.groovy.d')


String jobName = 'Pipemania'
if(Jenkins.instance.getItem(jobName)) {
	log.info "$jobName already exists"
} else {
	def job = Jenkins.instance.createProject(org.jenkinsci.plugins.workflow.job.WorkflowJob, jobName)
	String script = '''
// use library source from git
//library 'sharedlib-git@release'

// use library source from disk 
library 'sharedlib@release'

println(greet("el mundo"))

'''
	job.definition = new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition(script, true)
	build = job.scheduleBuild2(2)
	log.info "$jobName created"
}

