pipeline {
    agent { dockerfile true
            args '-p 8081:8081'
    }
    stages {
        stage('Test') {
                sh 'java -jar target/demo-0.0.1.jar'
        }
    }
}