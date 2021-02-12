pipeline {
    agent {
        dockerfile {
            args '-p 8081:8081'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'docker -v'
                sh 'java -jar target/demo-0.0.1.jar'
            }
        }
    }
}