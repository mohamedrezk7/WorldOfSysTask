# E2E Automation Testing Framework

📋 Prerequisites

Before running this project, ensure you have the following installed:
Required Tools

1-Java Development Kit (JDK) 11 or higher

2-Apache Maven 3.6+

3-Git (for version control)

4-IDE (IntelliJ IDEA, Eclipse, or VS Code)

# 1- Java Installation

Download JDK from Oracle or OpenJDK

setup Java jdk

Set JAVA_HOME environment variable

setx JAVA_HOME "C:\Program Files\Java\jdk-11.0.x"

setx PATH "%PATH%;%JAVA_HOME%\bin"

# 2. Maven Installation

Download Maven from https://maven.apache.org/download.cgi

Extract to C:\Program Files\Apache\maven

Set environment variables

setx M2_HOME "C:\Program Files\Apache\maven"

setx PATH "%PATH%;%M2_HOME%\bin"

# 4-Verify Installation

Check Java version -> java -version

Check Maven version -> mvn -version

# 5- Clone Project
git clone https://github.com/mohamedrezk7/WorldOfSysTask

# 6- Run Project Via Maven
- mvn clean install
# Run all tests 
- mvn clean test
- # Run smoke tests
- mvn test -Psmoke
# 7 Reports 

Will Find reports at - target/surefire-reports/index.html

