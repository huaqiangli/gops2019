pipeline {
    agent {
        label 'slave-1'
    }
    environment{
	    PIPELINE_ENV_VAR1 = "var defined at pipeline level"
	    JENKINS_AUTO_ACCOUNT= credentials('autobuilder-password')
    }
    tools {
        maven 'M3' 
    }
    stages {
	stage('Preparation') {
            environment{
		STAGE_ENV_VAR1 = "var defined within a stage"
	    }
            steps {
		sh 'printenv'
		git 'https://github.com/jglick/simple-maven-project-with-tests.git'
				
            }			
	}
	stage('Build') {
	    steps {
		 sh 'printenv'
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
