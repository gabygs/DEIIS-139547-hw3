#! /bin/bash
set -e
set -v
mvn clean package dependency:copy-dependencies
export UIMA_CLASSPATH=./target/:./target/dependency/
deployAsyncService.sh ./src/main/resources/scnlp-139547-client.xml -brokerURL tcp://localhost:61616
