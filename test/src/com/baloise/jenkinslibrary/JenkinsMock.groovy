package com.baloise.jenkinslibrary

class JenkinsMock {

    static create() {
        def jenkins = [:]
        jenkins.echo = { text -> println "echo: " + text }
        jenkins.sh = { cmd -> println "executed shell cmd: " + cmd }
        jenkins.ansiColor = { type, func -> func() }

        jenkins.git = { input -> println input }
        jenkins.error = { text -> println text }
        jenkins.withEnv = { array, func -> func() }
        jenkins.withCredentials = { array, func -> func() }
        jenkins.tool = { name -> return "/opt/maven" }
        jenkins.pwd = { -> return "/var/lib/jenkins/workspace/folder/job" }
        jenkins.scm = null
        jenkins.stage = { text, func -> println(text); func() }
        jenkins.wrap = { map, func -> func() }
        jenkins.answerInput = { input -> println "answer input" }

        jenkins.log = []

        jenkins.env = [:]
        jenkins.env.BITBUCKET_URL = "https://bitbucket.balgroupit.com"
        jenkins.env.CHARTMUSEUM_URL = "https://charts.shapp.os1.balgroupit.com"
        jenkins.env.QUAY_URL = "quay.balgroupit.com"
        jenkins.env.JENKINS_URL = "https://ci.balgroupit.com"
        jenkins.env.getProperty = { name -> return name }
        jenkins.currentBuild = [:]

        jenkins.USERNAME = "mockedUsername"
        jenkins.PASSWORD = "mockedPassword"


        jenkins.readYaml = { input ->
            jenkins.fileSystem.readYaml(input.file)
        }
        jenkins.writeFile = {
            file -> jenkins.fileSystem.writeFile(file)
        }

        jenkins.readFile = { path -> println "file read: " + path; return jenkins.fileSystem.readFile(path) }
        jenkins.fileExists = { name -> return jenkins.fileSystem.fileExists(name) }
        jenkins.sleep = { input -> jenkins.sleepMock.addSleep(input.time, input.unit) }
        jenkins.httpRequest = { map -> return map}

        return jenkins
    }


}
