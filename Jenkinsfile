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
                sh 'ls'
                sh 'mvn clean package'
                sh 'ls'
                sh 'cd target/'
                sh 'ls'
                junit '/home/ly_me/.jenkins/workspace/pac/target/surefire-reports/TEST-pac.TestCase.xml'  
                archive 'target/pac.war'
            }
        }
    }
}
