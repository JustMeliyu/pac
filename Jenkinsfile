pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-u root -v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                sh 'ls'
                sh 'mvn clean package'
                sh 'ls'
                sh 'cd target/'
                sh 'ls'
            }
        }
        stage('results'){
            steps{
                junit '/home/ly_me/.jenkins/workspace/pac/target/surefire-reports/test-pac.xml'  
                archive 'target/pac.jar'
            }
        }
        stage('deploy'){
            steps{
                whoami
                ssh cameltest@118.190.87.8 "sh dep.sh"
            }
        }
    }
}
