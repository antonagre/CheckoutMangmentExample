pipeline {
    agent {
        docker {
            image 'ubuntu:latest'
            label 'docker'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'uname -a'
                sh 'ls'
            }
        }
    }
}