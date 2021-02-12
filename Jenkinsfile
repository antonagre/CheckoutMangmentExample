pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'docker build -t backend -f Dockerfile .'
                sh 'java -jar target/demo-0.0.1.jar'
            }
        }
    }
}