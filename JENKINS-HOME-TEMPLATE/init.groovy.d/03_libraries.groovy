import org.jenkinsci.plugins.workflow.libs.*
import hudson.plugins.filesystem_scm.*
import jenkins.plugins.git.GitSCMSource;
import jenkins.model.*
import java.util.logging.Logger
Logger log = Logger.getLogger('init.groovy.d')

Properties config = new Properties()
new File(".git/config").withInputStream { config.load it}


SCMSourceRetriever retrieverGit = new SCMSourceRetriever(new GitSCMSource(
		config.url.replaceAll(/\W+/, ""),
		config.url,
		"",
		"*",
		"",
		false))

LibraryConfiguration libGit  = new LibraryConfiguration("sharedlib-git", retrieverGit)
libGit.setDefaultVersion("main")
libGit.setImplicit(false)

File sourceFolder = new File(".").absoluteFile.parentFile
SCMRetriever retrieverLocal = new SCMRetriever(new FSSCM(sourceFolder.path, false, false,
	new FilterSettings(false, [ new FilterSelector(".*/**"),new FilterSelector("target/**"), new FilterSelector("bin/**")])))

LibraryConfiguration libLocal  = new LibraryConfiguration("sharedlib", retrieverLocal)
libLocal.setDefaultVersion("release")
libLocal.setImplicit(false)
GlobalLibraries.get().libraries = [libLocal, libGit]
log.info "Libraries ${[libLocal, libGit].name} registered"
