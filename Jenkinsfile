node {
    stage ("Pull from Git") {
      checkout scm
    }
    stage ("Run Container") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            docker.image('ccc:latest').withRun('-p 8090:8081') {
                sh "ls target"
                //sh "java -jar target/demo-0.0.1-SNAPSHOT.jar"
            }
        }
    }

    stage ('Cucumber Reports') {
        cucumber buildStatus: "FAILED",
        fileIncludePattern: "**/cucumber.json",
        jsonReportDirectory: 'target'
   }
}