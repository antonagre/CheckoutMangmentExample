pipeline{

   agent any
   tools{
           maven '3.6.3'
       }

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

                withMaven {
                    sh 'mvn -Dtest=CucumberRunner test'

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
