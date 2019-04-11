
// Jenkinsfile of repo https://github.com/huaqiangli/myegg2.git
pipeline {
  agent any
  options {
     skipDefaultCheckout()
  }
  stages {
    stage('checkout code') {
      steps {
        echo "checkout the code from test branch"
        //checkout scm
        git 'https://github.com/huaqiangli/myegg2.git'
        sh 'ls -l'
      }
    }
    stage('build') {
      steps {
        sh 'echo "build the package"'
      }
    }
  }
}
