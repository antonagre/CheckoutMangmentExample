node {
    checkout scm

    docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
        docker.image('base:latest').withRun('-p 8090:8081') {
            sh "java -jar target/demo-0.0.1-SNAPSHOT.jar"
        }
    }
}