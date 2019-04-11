pipeline {
    agent {
        label 'slave-1'
    }
    tools {
        maven 'M3' 
    }
    stages {
	stage('Preparation') {
            steps {
	       git 'https://github.com/jglick/simple-maven-project-with-tests.git'
            }			
	}
	stage('Build') {
            steps {
	        script{
		   if (isUnix()) {
                       sh 'mvn -Dmaven.test.failure.ignore clean package'
                   } else {
                       bat 'mvn -Dmaven.test.failure.ignore clean package'
                   }
	        }
	    }
	}
	stage('Results'){
	     steps{
	         junit '**/target/surefire-reports/TEST-*.xml'
		 archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, onlyIfSuccessful: true
	     }
	}
   }
}

