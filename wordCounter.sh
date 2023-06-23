#!/bin/bash

# Set the paths and filenames
APP_DIR="./app"
APP_JAR="$APP_DIR/build/libs/app.jar"

./gradlew clean build --quiet

# Check if an input file is provided
if [ $# -eq 0 ]; then
  echo "Usage: $0 <input_file_path>"
  exit 1
fi

# Run the application
java -jar "$APP_JAR" "$1"
