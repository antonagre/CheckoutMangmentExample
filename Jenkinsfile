node {
    stage ("Pull from Git") {
      checkout scm
    }
    stage ("Run Container") {
        docker.withServer('tcp://aadev.ml:4243', 'swarm-certs') {
            docker.image('ccc:latest').withRun('-p 8090:8081 --name cccc -it ccc:latest java -jar target/demo-0.0.1-SNAPSHOT.jar ') {  c ->

            }
        }
    }

    stage ('Cucumber Reports') {
        cucumber buildStatus: "FAILED",
        fileIncludePattern: "**/cucumber.json",
        jsonReportDirectory: 'target'
   }
}