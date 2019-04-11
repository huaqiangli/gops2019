
// the Jenkinsfile of repo https://github.com/huaqiangli/myegg.git
pipeline {
  agent any
  stages {
    stage('checkout code') {
      steps {
        echo "checkout the code"
        //checkout scm
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
