#Install 
Go to Tech directory and run the following command
./gradlew build

# Running Integration Test

# Running Functional Test
Run the following command
./gradlew test

The test can run in Chrome or Firefox browsers and the browser is defined inside functionalTest/config.properties
For running the test in Firefox change the browser value to 'ff' and to run it in chrome set it as 'chrome' 
The test can run in different environments.
For running it in anywhere else other than localhost change the baseURI and Port value.