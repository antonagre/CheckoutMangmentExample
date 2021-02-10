pipeline{
   agent any
   tools {
      maven "3.6.3"
   }
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
