pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '1'))
    }
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
                script {
                    if(env.BRANCH_NAME == "master") {
                        sh './gradlew build --profile'
                    }
                    if(env.BRANCH_NAME == "develop") {
                        sh './gradlew lintDebug'
                        sh './gradlew testDebugUnitTest'
                        sh './gradlew assembleDebug --profile'
                    }
                }
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/apk/**/*.apk', onlyIfSuccessful: true
                archiveArtifacts artifacts: 'build/reports/profile/**/*.*'
            }
        }

    }
}