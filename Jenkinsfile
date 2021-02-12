pipeline {
    agent {
        dockerfile {
            args '-p 8081:8081'
            label 'docker'
        }
    }
    stages {
        stage('Test') {
                sh 'java -jar target/demo-0.0.1.jar'
        }
    }
}