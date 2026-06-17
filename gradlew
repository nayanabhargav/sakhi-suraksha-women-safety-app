#!/usr/bin/env sh

##############################################################################
#
#   Gradle start-up script for UN*X
#
##############################################################################

APP_BASE_NAME=`basename "$0"`
APP_HOME=`dirname "$0"`

# Add default JVM options here.
DEFAULT_JVM_OPTS=""

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

# Determine the Java command to use
if [ -n "$JAVA_HOME" ] ; then
    JAVA_CMD="$JAVA_HOME/bin/java"
else
    JAVA_CMD="java"
fi

# Determine our Gradle installation
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

# Execute Gradle
exec "$JAVA_CMD" $DEFAULT_JVM_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
