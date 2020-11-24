import jenkins.model.*
import hudson.*
import hudson.model.*
import java.util.logging.Logger
Logger log = Logger.getLogger('init.groovy.d')

def plugins = ["workflow-aggregator", "filesystem_scm", "git", 'pipeline-utility-steps', 'http_request', 'docker-plugin', 'docker-workflow']
PluginManager pm = Jenkins.instance.pluginManager
UpdateCenter uc = Jenkins.instance.updateCenter
def site = uc.getSite(uc.ID_DEFAULT)
if(site.isDue() || !site.availables) {
	log.info 'Updating plugin registry'
	site.updateDirectlyNow(true)
}

plugins.each {
  if (!pm.getPlugin(it)) {
	def plugin = uc.getPlugin(it)
	if (plugin) {
	  log.info "Installing " + it
	  plugin.deploy(true)
	  while(!uc.getJob(plugin).status.success){
		  log.info "waiting for plugin $it to be installed"
		  sleep 2000
	  }
	}
  }
}