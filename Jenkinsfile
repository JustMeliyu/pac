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
    }
}
