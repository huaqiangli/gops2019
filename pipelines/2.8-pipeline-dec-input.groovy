pipeline {
    agent any 
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')
    }
    environment {
        workspace=pwd()
    }
    parameters {
       booleanParam defaultValue: true, description: 'a boolean parameter', name: 'Run_unit_test'
    }
    stages {
        stage('Checkout code'){
            steps{
                echo "checkout code under ${workspace}"
                git 'https://github.com/vasouv/BankingUnitTests.git'
                
            }
        }
        stage('Build') { 
            steps { 
                echo "build the code"
                sh 'mvn clean package'
                sh 'ls -l target/'
            }
        }
        stage('Unit Test'){
            when { expression { return params.Run_unit_test }}
            steps {
                echo 'make unit test'
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('results'){
            steps{
                stash name: "first-stash", includes: "target/*.jar"
            }
            
        }
        stage('Smoke Test') {
           parallel{
              stage('smoke test on linux slave 1'){
	          agent{ label 'slave-1'}
                  steps {
                       sh 'mkdir -p slave1-stash'
		       dir("slave1-stash"){
		           unstash "first-stash" 
		       }
                       echo 'Smoke Testing in linux ....'
                  }
	      }
	      stage('smoke test on linux slave 2'){
		   agent{ label 'slave-2'}
                   steps {
                       sh 'mkdir -p slave2-stash'
		       dir("slave2-stash") {
                           unstash "first-stash"
                       }
                       echo 'Smoke Testing in linux ....'
                   } 
	      }
          }			
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                script{
                    env.deployEnv = input message: 'select the env to deploy', ok: 'deploy', parameters: [choice(name: 'deployEnv', choices: 'DEV\nQA\nSTAGE\nPRODUCTION', description: 'Are you sure to deploy?')]
                }
                echo "deploy to ${env.deployEnv}"               
            }
        }
    
    }
}
