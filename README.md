# Office for Product Safety & Standards Services - Functional Test Suites

[![Build Status](https://circleci.com/gh/UKGovernmentBEIS/opss-functional-tests.svg?style=svg)](https://circleci.com/gh/UKGovernmentBEIS/opss-functional-tests)

## Getting Setup

## Deployment

Anything which is merged to the `master` branch (via a Pull Request or push) will trigger the
[CircleCI build](https://circleci.com/gh/UKGovernmentBEIS/workflows/opss-functional-tests)
and push an updated Docker image to the [Docker Hub repository](https://hub.docker.com/r/beisopss/opss-functional-tests)
if the build is successful.

Docker images are tagged with the CI build number and the latest image is also tagged `latest`
and used by other CI builds to run regression and smoke tests.

The CircleCI build configuration and workflows are declared in the [config.yml](.circleci/config.yml) file.

You can pull the Docker image and run the regression tests locally by running the following commands:

    docker pull beisopss/opss-functional-tests
    docker run beisopss/opss-functional-tests mvn --quiet --file ./cosmetics/pom.xml test -Dcucumber.options="--tags @regression" \
      -Dhostname=${SERVICE_HOSTNAME} -Dauth.username=${BASIC_AUTH_USERNAME} -Dauth.password=${BASIC_AUTH_PASSWORD} \
      -Daccount.opss.username=${OPSS_ACCOUNT_USERNAME} -Daccount.opss.password=${OPSS_ACCOUNT_PASSWORD} \
      -Daccount.npis.username=${NPIS_ACCOUNT_USERNAME} -Daccount.npis.password=${NPIS_ACCOUNT_PASSWORD} \
      -Daccount.rp.username=${RP_ACCOUNT_USERNAME} -Daccount.rp.password=${RP_ACCOUNT_PASSWORD} \
      -Daccount.ts.username=${TS_ACCOUNT_USERNAME} -Daccount.ts.password=${TS_ACCOUNT_PASSWORD} \

where the relevant values for, e.g., `$SERVICE_HOSTNAME` must be specified as environment variables
or passed in directly.
