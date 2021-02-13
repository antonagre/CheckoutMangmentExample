node {
    stage ("Pull from Git") {
      checkout scm
    }
    stage ("Run Container") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker stop checkout'
            sh 'docker run -p 8090:8082 --rm --name checkout -itd ccc:latest java -jar target/demo-0.0.1-SNAPSHOT.jar '
        }
    }

    stage ("Run Cucumber Tests") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker run --rm --name checkouTest -itd ccc:latest mvn -X -Dtest=Runner test'
        }
    }

    stage ('Cucumber Reports') {
        cucumber buildStatus: "FAILED",
        fileIncludePattern: "**/cucumber.json",
        jsonReportDirectory: 'target'
   }
}
