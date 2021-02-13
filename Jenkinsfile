node {
    checkout scm

    docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
        docker.image('base:latest').withRun('-p 8090:8081') {
            sh "ls -lah target/"
        }
    }
}