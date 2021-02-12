pipeline{
   agent any

   
   stages {
        stage ('Compile Stage') {
            steps {
                withMaven {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
   stage ('Test Stage') {
            steps {
                withMaven {
                    bat 'mvn clean install'
                }
            }
        }

   }
}
