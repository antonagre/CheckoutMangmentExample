node {
    stage ("Pull from Git") {
      checkout scm
    }
    stage ("Build Container Image") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker build -t checkout-image .'
        }
    }
    stage ("Run Container") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker run -p 8090:8082 --rm --name checkout -itd checkout-image:latest java -jar target/demo-0.0.1-SNAPSHOT.jar '
        }
    }

    stage ("Run Cucumber Tests") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker run --rm --name checkouTest checkout-image:latest mvn -X -Dtest=Runner test'
            sh 'docker stop checkout'
        }
    }

    stage ('Cucumber Reports') {
        cucumber buildStatus: "FAILED",
        fileIncludePattern: "**/cucumber.json",
        jsonReportDirectory: 'target'
   }
}
