# containerBuild

Builds a container image and pushes it to a image registry. Mandatory parameters are marked with an asterisk (*).

| Parameter | Description | Default |
|---|---|---|
| registry | Registry where the built images should be pushed | `QUAY_URL` env variable |
| repository* | Name of the repository where the images should be pushed. e.g. `teamname/repository`.  ||
| tags | Array of tags which should be applied to the built image | `["latest"]` |
| dockerFileName | Name/Path to the Dockerfile which is used to build the container image | `Dockerfile` |
| path | Path in the Git repository where the container build is executed | `.` |
| cacheLayers | Cache intermediate images during the build process. Passes as the [`--layers`](https://github.com/containers/libpod/blob/master/docs/source/markdown/podman-build.1.md) argument. | `false` |
| buildArgs | Array of build args which are passed as [`--build-arg`](https://github.com/containers/libpod/blob/master/docs/source/markdown/podman-build.1.md). These are available as environment variables during build time. e.g. `["ENV1=value"]` | `[]` |
| pullAlways | Always pull the base image defined in the Dockerfile (`FROM quay.balgroupit.com/org/repo:tag`) | `true` |


## Jenkins Configuration requirements

### Required Global variables 
| Variable name | Description | 
|---|---|
| `QUAY_URL` | Variable pointing to quay docker registry. |

### Required Credentials
| ID | Description |
|---|---|
| `quay-admin-user` | Credential with permission to push to quay. |


## Example usage in a pipeline

```groovy
@Library('jenkins-shared-library@release') _

pipeline {

    agent {
        label 'podman'
    }

    options {
        skipStagesAfterUnstable()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '28'))
        timeout(time: 1, unit: 'HOURS')
        timestamps()
    }

    stages {
        stage("Build and Push") {
            steps {
                notifyBitBucket state: "INPROGRESS"
                script {
                    currentBuild.description = GIT_COMMIT
                }
                containerBuild(repository: 'example/nginx-sample', tags: [GIT_COMMIT])
            }
        }
    }

    post {
        success {
            notifyBitBucket state: "SUCCESSFUL"
        }

        fixed {
            mailTo status: "SUCCESS", actuator: true, recipients: [], logExtract: true
        }

        failure {
            notifyBitBucket state: "FAILED"
            mailTo status: "FAILURE", actuator: true, recipients: [], logExtract: true
        }
    }
}

```