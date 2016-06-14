#!/bin/sh

mvn clean install

snapshot_folder=~/camunda-bpm-tomcat-7.5.0/server/apache-tomcat-8.0.24/webapps/loan-approval-0.1.0-SNAPSHOT
snapshot_war=~/camunda-bpm-tomcat-7.5.0/server/apache-tomcat-8.0.24/webapps/loan-approval-0.1.0-SNAPSHOT.war

if [ -d $snapshot_folder ] ; then
	rm -r $snapshot_folder
fi

if [ -f $snapshot_war ] ; then
	rm $snapshot_war
fi

cp target/loan-approval-0.1.0-SNAPSHOT.war ~/camunda-bpm-tomcat-7.5.0/server/apache-tomcat-8.0.24/webapps/loan-approval-0.1.0-SNAPSHOT.war
