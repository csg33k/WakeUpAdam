#!/bin/bash
JAVA=/usr/lib/jvm/java-6-sun-1.6.0.22/jre/bin/java
BASE=$(dirname $0)
SCRIPTDIR=$BASE/..
echo ${JAVA} -cp "${SCRIPTDIR}/target/wakeupAdam-1.0-SNAPSHOT.jar:${SCRIPTDIR}/target/lib/*" com.esamir.gvoice.Main
${JAVA} -cp "${SCRIPTDIR}/target/wakeupAdam-1.0-SNAPSHOT.jar:${SCRIPTDIR}/target/lib/*" com.esamir.gvoice.Main
