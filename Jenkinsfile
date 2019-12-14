pipeline {
    agent any
    stages {
        stage('Checkout') {
            checkout([$class: 'GitSCM', branches: [[name: '**']], doGenerateSubmoduleConfigurations: false, extensions: 
                [[$class: 'CleanCheckout']],
                submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: 'github',
                url: 'https://github.com/kursivee/android-jenkins-learning.git']]])
        }
    }
}