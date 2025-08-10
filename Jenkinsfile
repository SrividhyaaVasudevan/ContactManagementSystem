pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output/ExtentReports/ExtentReport.html',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished. Reports published.'
        }
    }
}
