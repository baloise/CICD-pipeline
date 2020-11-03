import jenkins.model.*

String proxyConf = System.getProperty("https_proxy") ?: System.getProperty("http_proxy") ?: System.getenv("https_proxy") ?: System.getenv("https_proxy")
if(proxyConf) {
	String noProxy = System.getProperty("no_proxy") ?: System.getenv("no_proxy")
	URL url = new URL(proxyConf)
	def (usr, pwd ) = (url.userInfo?:":").split(":",2)
	final def pc = new hudson.ProxyConfiguration(url.host, url.port, usr, pwd, noProxy, "https://example.com")
	Jenkins.instance.proxy = pc
	Jenkins.instance.save()
	println "Proxy settings updated"	
}
