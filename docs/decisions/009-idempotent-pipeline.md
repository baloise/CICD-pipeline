# 9. Idempotent pipeline

Date: 2020-11-05

## Status

Recommended

## Context

1) (Parameterless pipeline)[011-parameterless-pipeline.md]
1) (Single pipeline)[010-parameterless-pipeline.md]

## Decision

The pipeline runs with negligible side effects and has the same outcome regardless of the state of the target system at the start of the pipeline run.
In other words the pipeline ensures the system operates in the state described in version control after the run regardless of the state before the run.

## Consequences

The pipeline need to detect IS and TARGET state, calculate and apply the delta.
