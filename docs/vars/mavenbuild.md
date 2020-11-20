# mavenbuild

⚠️ deprecated


Mandatory parameters are marked with an asterisk (*).

| Parameter | Description | Default |
|---|---|---|
| cmd | | `clean deploy` |
| mavenArgs | additional cmd | |
| mavenVersion |   |  |
| jdkVersion | openJDK_1_10 or openJDK_1_10 | |
| uploadArtifactsWithBranchnameInVersion | When true the artifact is uploaded with the sanitized branch name in the version definition (not for master and only for SNAPSHOTS). Example: Branch name: feat/1, version: 1.0.0-SNAPSHOT -> 1.0.0-feat-1-SNAPSHOT | `false` |


## Jenkins Configuration requirements

TBD.

### Required Global variables 

TBD.

### Required Credentials

TBD.

## Example usage in a pipeline

```groovy

library 'sharedlib@release'

mavenbuild()

mavenbuild cmd: "test", mavenArgs: "-DskipTests=true"

mavenbuild jdkVersion: "openJDK_1_9"

```