pipeline {
    agent none
    stages {
        stage('Build Docker Backend') {
            agent {
                any
            }
            steps {
                sh 'build -t base .'
            }
        }
        stage('Run Backend') {
            agent {
            docker {
                image 'base:latest'
                args '-p 8081:8081'
            }
            steps {
                sh 'java - jar target/*.jar'
            }
        }
    }
}