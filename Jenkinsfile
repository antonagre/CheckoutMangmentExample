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
            steps {
                docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
                    sh 'docker build -t checkout-image .'
                    sh 'docker run -p 8090:8082 --rm --name checkout -itd checkout-image:latest java -jar *.jar '
                }
            }
        }


        stage ('Test Stage') {
            steps {
                withMaven {
                    sh 'mvn -Dtest=RunCucumberRunner test'
                }
            }
        }

        stage ('Test Stage') {
            steps {
                docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
                    sh 'docker stop checkout'
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

