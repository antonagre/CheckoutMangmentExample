pipeline{
   agent any
   stages {
        stage ('Compile Stage') {
            steps {
                withMaven {
                    sh 'mvnw clean install -DskipTests'
                }
            }
        }
   stage ('Test Stage') {
            steps {
                withMaven {
                    sh 'mvnw clean install'
                }
            }
        }

   }
}
