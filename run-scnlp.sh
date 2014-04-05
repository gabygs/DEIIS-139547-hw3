#! /bin/bash
set -e
set -v
export UIMA_CLASSPATH=./target/:./target/dependency/
runRemoteAsyncAE.sh tcp://localhost:61616 scnlp-139547 -c ./src/main/resources/hw3-139547-fileSystemCollectionReader_Descriptor.xml