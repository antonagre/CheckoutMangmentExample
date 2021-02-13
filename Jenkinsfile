node {
    stage ("Pull from Git") {
      checkout scm
    }

    stage ("Build Container Image") {
        sh 'mvn clean install -DskipTests'
    }

    stage ("Run Container") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker build -t checkout-image .'
            sh 'docker run -p 8090:8082 --rm --name checkout -itd checkout-image:latest java -jar *.jar '
        }
    }

    stage ("Run Cucumber Tests") {
        sh 'mvn -X -Dtest=Runner test'
    }

    stage ("Remove Test Spring Container") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            sh 'docker stop checkout'
        }
    }

    stage ('Cucumber Reports') {
        cucumber buildStatus: "FAILED",
        fileIncludePattern: "**/cucumber.json",
        jsonReportDirectory: 'target'
   }
}
