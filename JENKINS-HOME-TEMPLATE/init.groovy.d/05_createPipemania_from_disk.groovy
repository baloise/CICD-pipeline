import jenkins.model.*
import hudson.*
import hudson.model.*
import org.jenkinsci.plugins.workflow.libs.*
import hudson.plugins.filesystem_scm.*
import hudson.scm.SCM

import java.util.logging.Logger

import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition
import org.jenkinsci.plugins.workflow.job.WorkflowJob
Logger log = Logger.getLogger('init.groovy.d')


String jobName = 'Pipemania-from-disk'
if(Jenkins.instance.getItem(jobName)) {
	log.info "$jobName already exists"
} else {
	WorkflowJob job = Jenkins.instance.createProject(org.jenkinsci.plugins.workflow.job.WorkflowJob, jobName)
	job.definition = new CpsScmFlowDefinition( 
						new FSSCM(
							new File("JENKINS-HOME-TEMPLATE/pipemania").absolutePath, 
							false, 
							false,
							new FilterSettings(
								false, 
								[ 
									new FilterSelector(".*/**"),
									new FilterSelector("target/**"), 
									new FilterSelector("bin/**")
								]
							)
						), 
						"Jenkinsfile"
					)
	build = job.scheduleBuild2(2)
	log.info "$jobName created"
}




