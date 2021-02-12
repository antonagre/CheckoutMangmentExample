pipeline {
    agent {
        dockerfile {
            label 'docker'
            args '-p 8081:8081'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'java -jar target/demo-0.0.1.jar'
            }
        }
    }
}