pipeline {
    agent {label 'local'}
    stages {
        stage('Build') {
            agent{
                docker {
                    image 'maven:3-alpine'
                    args '-u root -v $HOME/.m2:/root/.m2'
                }
            }
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
            agent{
                docker {
                    image 'maven:3-alpine'
                    args '-u root -v $HOME/.m2:/root/.m2'
                }
            }
            steps{
                junit '/home/ly_me/.jenkins/workspace/pac/target/surefire-reports/TEST-pac.xml'  
                archive 'target/pac.war'
            }
        } 
        
        stage('deploy'){
            agent { label 'uat_118.190.87.8'}
            steps{
                sh 'whoami'
                sh 'sh dep.sh'
            }
        }
    }
    
}
