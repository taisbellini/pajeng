#!/bin/bash

pushd PajeQueries/src/br/ufrgs/inf/tlbellini/
export CLASSPATH=../..//include/mysql-connector-java-5.1.38-bin.jar:.
javac queries/*.java
popd
export CLASSPATH=`pwd`/JavaQueries/src/


