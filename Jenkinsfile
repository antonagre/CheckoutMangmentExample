pipeline{
   agent any
   
   tools {
      maven "3.6.3"
   }
   
   stages {
        stage ('Compile Stage') {
            steps {
                withMaven {
                    sh 'mvn clean install -DskipTests && java -jar target/demo-0.0.1-SNAPSHOT.jar &'
                }
            }
        }
   stage ('Test Stage') {
            steps {
                withMaven {
                    sh 'mvn clean install '
                }
            }
   }
    stage ('Cucumber Reports') {
            steps {
             cucumber buildStatus: "FAILED",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'
            }
        }
    }
}
