# Nextflow WR 

Nextflow extension module for [wr](https://github.com/VertebrateResequencing/wr)

This allows submitting jobs to LSF while taking advantage of LSF
job arrays, and to an OpenStack cluster with autoscaling up and down.

To enable this executor set the property ``process.executor = 'wr'`` in the
``nextflow.config`` file.

The pipeline can be launched either on a local computer or an OpenStack instance.
That computer or instance must be running wr manager.

To start running wr, install wr by downloading it, unzipping it and optionally
placing it in your $PATH. Then for LSF usage run:

    wr manager start -s lsf

For OpenStack usage, additionally source your OpenStack credentials "rc" file and
run:

    wr cloud deploy

Your options to "deploy" or your wr configuration determine the default image
and allowed flavors that will be used to run tasks. Amongst the allowed flavors,
wr will pick the smallest flavor that is large enough to run your tasks,
according to the cpu, memory and disk requirements of each task.

When using OpenStack, an S3 bucket must be used as pipeline work directory and
for pipeline file inputs. This means nextflow must be configured with access
details of your S3 system, and wr must also be aware of those details. This can
be arranged most easily by having an ~/.s3cfg file (the file you would need for
the s3cmd tool).

See wr's [wiki](https://github.com/VertebrateResequencing/wr/wiki/Nextflow) for
more details.

## Dir structure

* `src/main`: Module source files
* `src/resources`: Module non source resources
* `src/test`: Module unit test sources

## Build 

```
./gradlew compileGroovy
```
