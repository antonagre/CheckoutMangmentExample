pipeline {
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
        stage('Test') {
            steps {
                sh 'screen java -jar target/demo-0.0.1.jar'
            }
        }
    }
}