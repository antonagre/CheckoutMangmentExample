pipeline{
    stages {
        stage('Back-end') {
            agent {
                docker {
                image 'base-checkout'
                args '-p 8081:8081'
                }
            }
            steps {
                sh 'java -jar target/demo-0.0.1.jar'
            }
        }
    }
}
