# 11. Parameterless pipeline

Date: 2020-11-05

## Status

Recommended

## Context

1) We need to ensure traceability to fullfil regulatory requirements
1) We need to be able to replay pipelines unattended for recovery / business continuity
1) We aim for efficient pipelines with minimal manual interactions

## Decision

1) All information required to build the running system and its environment is stored in the version control system
1) The pipeline can be run on an event or schedule without manual interaction

## Consequences

1) Approval needs either to be stored in the version control system or the approval state must be accessible via API