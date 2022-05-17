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

        stage('Checkout') {
            steps {
                git branch: "${GIT_BRANCH}", url: "${GIT_REPOSITORY}"
            }
        }

        stage('Fortify Source Code Analyzer') {
            steps {
                echo "Running Source Code Analyzer"
                git branch: "${GIT_BRANCH}", poll: false url: "${GIT_REPOSITORY}"
                script {
                    env.FILE = sh(
                        script: "find ${env.WORKSPACE}/root/src -name '*.java'",
                        returnStdout: true
                    ).trim()
                    echo "${env.FILE}"
                    fortifyClean addJVMOptions: '', buildID: 'root', logFile: '', maxHeap: ''
                    fortifyTranslate addJVMOptions: '', buildID: 'root', excludeList: '', logFile: '', maxHeap: '', projectScanType: fortifyJava(javaAddOptions: '-cp ${WORKSPACE}/"SecScan/WEB_INF/lib/*', javaClasspath: '', javaSrcFiles: "$env.FILE", javaVersion: '1.8')
                    fortifyScan addJVMOptions: '', addOptions: '-machine-output', buildID: 'root', customRulepacks: '', logFile: '', maxHeap: '', resultsFile: 'root.fpr'
                }
                archiveArtifacts 'root.fpr'
                stash includes: 'root.fpr', name: 'root.fpr'
            }
        }

        stage('Building Package') {
            steps {
                echo "Building Maven Package!"
                //sh 'mvn clean package '
            }
        }
    }

    post {
        always {
            jacoco execPattern: '**/jacoco.exec'
        }
    }
}