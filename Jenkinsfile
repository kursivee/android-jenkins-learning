pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '**']], doGenerateSubmoduleConfigurations: false, extensions: 
                    [[$class: 'CleanCheckout']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'github',
                    url: 'https://github.com/kursivee/android-jenkins-learning.git']]])
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}