#!/bin/bash
JAVA=$(which java)
BASE=$(dirname $0)
SCRIPTDIR=$BASE/..
echo ${JAVA} -cp "${SCRIPTDIR}/target/wakeupAdam-1.0-SNAPSHOT.jar:${SCRIPTDIR}/target/lib/*" com.esamir.gvoice.Main
${JAVA} -cp "${SCRIPTDIR}/target/wakeupAdam-1.0-SNAPSHOT.jar:${SCRIPTDIR}/target/lib/*" com.esamir.gvoice.Main
