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
                    try {
                        sh 'docker container stop checkout'
                        echo 'Checkout container removed'
                    }
                    catch (all){
                       echo 'no checkout container running'
                    }
                    sh 'docker build -t base .'
                    sh 'docker run -p 8085:8085 --rm -itd --name checkout base:latest java -jar target/*.jar'
                    sleep 10
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

