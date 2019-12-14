pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '**']], doGenerateSubmoduleConfigurations: false, extensions: 
                    [[$class: 'CleanBeforeCheckout']],
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
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '/app/build/outputs/apk/*.apk', onlyIfSuccessful: true
            }
        }
    }
}