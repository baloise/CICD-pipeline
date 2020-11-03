import jenkins.model.*
import hudson.*
import hudson.model.*

def plugins = ["workflow-aggregator", "filesystem_scm", "git", 'pipeline-utility-steps', 'http_request']
PluginManager pm = Jenkins.instance.getPluginManager()
UpdateCenter uc = Jenkins.instance.getUpdateCenter()
def site = uc.getSite(uc.ID_DEFAULT)
if(site.isDue() || !site.availables) {
	println 'Updating plugin registry'
	site.updateDirectlyNow(true)
}

plugins.each {
  if (!pm.getPlugin(it)) {
	def plugin = uc.getPlugin(it)
	if (plugin) {
	  println("Installing " + it)
	  plugin.deploy(true)
	  while(!uc.getJob(plugin).status.success){
		  println "waiting for plugin $it to be installed"
		  sleep(2000)
	  }
	}
  }
}