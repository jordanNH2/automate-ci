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
                sh 'mvn clean package'
            }
        }

/*         stage('Building Docker Image') {
            steps {
                sh 'mvn dockerfile:build'
            }
        } */
    }

    post {
        always {
            jacoco execPattern: '**/jacoco.exec'
        }
    }
}