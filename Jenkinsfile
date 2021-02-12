pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'docker build -t 63db44a02c5ba1c4cf95c7c6885e8028a2cdba9e -f Dockerfile .'
                sh 'java -jar target/demo-0.0.1.jar'
            }
        }
    }
}