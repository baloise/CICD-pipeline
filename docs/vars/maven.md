# maven 

see https://maven.apache.org/

Mandatory parameters are marked with an asterisk (*).

| Parameter | Description | Default |
|---|---|---|
| name | Who to greet | `Nobody` |

## Jenkins Configuration requirements

None.

### Required Global variables 

None.

### Required Credentials

None.

## Example usage in a pipeline

```groovy

library 'sharedlib@release'

println(greet("el mundo"))

```
