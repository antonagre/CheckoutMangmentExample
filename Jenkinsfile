pipeline{
   agent any
   stages {
        stage ('Compile Stage') {
            steps {
                withMaven {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }
   stage ('Test Stage') {
            steps {
                withMaven(maven: 'mvn') {
                    sh 'mvn clean install'
                }
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
