pipeline{
   agent any

   tools{
           maven '3.6.3'
   }

   stages {
       stage ("Pull from Git") {
           steps {
               checkout scm
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
            docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
                sh 'docker build -t base .'
                sh 'docker run -p 8090:8082 --rm --name checkout -itd base:latest java -jar target/*.jar '
            }
        }


        stage ('Test Stage') {
            steps {
                withMaven {
                    sh 'mvn -Dtest=RunCucumberRunner test'
                }
            }
        }

        stage ('Remove Test Container') {
            steps {
                sh 'docker stop checkout'
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

