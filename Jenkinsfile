pipeline{
   agent any
   
   tools {
      maven "3.6.3"
   }
   
   stages {
        stage('Back-end') {
            agent {
                docker {
                image 'base-checkout'
                args '-p 8081:8081'
                }
            }
            steps {
                sh 'java -jar target/demo-0.0.1.jar'
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
