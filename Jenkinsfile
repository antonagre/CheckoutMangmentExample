pipeline {
    agent { dockerfile true }
    stages {
        stage('Backend') {
            steps {
                sh 'java -jar target/*.jar'
            }
        }
    }
}