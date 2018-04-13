pipeline {
    agent{
        docker {
            image 'maven:3-alpine'
            args '-u root -v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                //sh 'ls'
                //sh 'mvn clean package'
                //sh 'ls'
                //sh 'cd target/'
                // sh 'ls'
            }
        }
        stage('deploy'){
            steps{
                whoami
                sh "ansible test -m script -a 'deploy.sh'"
                sh "ansible-playbook playbook.yml -f 10"
            }
        }
    }
}
