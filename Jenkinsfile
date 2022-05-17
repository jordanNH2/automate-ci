pipeline {
    agent {
        label 'maven'
    }

    stages {
        stage('Initialize') {
            steps {
                script {
                    def dockerHome = tool 'Docker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                }
            }
        }
         stage('Building Package') {
            steps {
                sh 'mvn clean package '
            }
        }
    }

    post {
        always {
            jacoco execPattern: '**/jacoco.exec'
        }
    }
}