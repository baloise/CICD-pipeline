# this is superseeded by https://github.com/baloise/automagic

.

.

.

.

.

.

.

.

.



# CICD-pipeline
continuous integration and deployment for applications @ Baloise

[We](https://github.com/orgs/baloise/teams/cicd-pipeline/members) are [currently working](https://github.com/baloise/CICD-pipeline/projects/1) in [weekly sprints](https://github.com/baloise/CICD-pipeline/milestones) on [the MVP](https://github.com/baloise/CICD-pipeline/wiki/CICD-pipeline-MVP) 


# Use
 
To use in your pipeline add the following to the top of your Jenkinsfile

```
library identifier: 'sharedlib@release', retriever: modernSCM(
  [$class: 'GitSCMSource', remote: 'https://github.com/baloise/CICD-pipeline.git']
)
```

then use as any inbuilt command, for example

```
greet 'World'
```

# Contribute

It is very easy to write pipeline steps - have a look at the existing code, i.e. [greet.groovy](./vars/greet.groovy) and  [greet.txt](./docs/vars/greet.md). 

Yes please take the time to write a minimal documentation ;-) 

For a deep dive please read the [official documentation](https://jenkins.io/doc/book/pipeline/shared-libraries/).  


# dev setup

You can use [jenkins-maven-plugin](https://github.com/baloise/jenkins-maven-plugin) ... 

```
mvn -Djenkins.home=/this/folder/might/grow/big/JENKINS_HOME jenkins:run
```

Enter "exit" on the console to end jenkins process.

On the first run all necessary plugins are installed - this may take some minutes. 

Head over to [http://localhost:8080/](http://localhost:8080/) and use the template jobs to get you up and running 🚀.

## behind a proxy
Set `http_proxy` / `no_proxy` properties / environment variables, see [JENKINS-HOME-TEMPLATE/init.groovy.d/01_proxy.groovy](./JENKINS-HOME-TEMPLATE/init.groovy.d/01_proxy.groovy)


https://baloise.github.io/CICD-pipeline/site/main/linecoverage.svg

If you need a forwarding proxy, have a look at [https://github.com/baloise/proxy](https://github.com/baloise/proxy#installation) 



[![Line Coverage](https://baloise.github.io/CICD-pipeline/site/main/linecoverage.svg)](https://baloise.github.io/CICD-pipeline/site/main/jacoco)
