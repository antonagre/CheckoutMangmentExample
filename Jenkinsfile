pipeline{
   agent any

   tools{
           maven '3.6.3'
   }

   stages {

        stage ('Remove Test Container') {
            steps {
                sh 'docker stop checkout'
            }
        }

        stage ('Compile Stage') {
            steps {
                withMaven {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage ('Build And Run Container') {
            steps {
                sh 'docker build -t checkout-image .'
                sh 'docker run -p 8090:8082 --rm --name checkout -d checkout-image:latest java -jar target/*.jar '
            }
        }


        stage ('Test Stage') {
            steps {
                withMaven {
                    sh 'mvn -Dtest=RunCucumberRunner test'
                }
            }
        }
        stage ("Pull from Git") {
            steps {
                checkout scm
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

