node {
    checkout scm

    docker.withServer('tcp://aadev.ml:2376', 'swarm-certs') {
        docker.image('ubuntu:latest').withRun('-p 8081:8090') {
            sh "ls -lah"
        }
    }
}