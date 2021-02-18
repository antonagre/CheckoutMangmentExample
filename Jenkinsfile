pipeline{
   agent any

   tools{
           maven '3.6.3'
   }

   stages {
       stage ("Pull from Git") {
           steps {
               cleanWs()
               checkout scm
           }
       }

        stage ('Compile Stage') {
            steps {
                withMaven {
                    sh 'mvn clean install -DskipTests'
                    sh 'ls target'
                }
            }
        }

        stage ('Build And Run Container') {
            steps{
                script {
                    echo "DOCKER: checkout container"
                    sh 'docker build -t base .'
                    sh 'docker run -p 8085:8085 -itd --name checkout base:latest java -jar target/*.jar'
                    sh 'docker container ls'
                }
            }
        }



        stage ('Test Stage') {
            steps {
                withMaven {
                    sh 'mvn -Dtest=Runner test'
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

