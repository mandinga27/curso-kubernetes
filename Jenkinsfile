@Library('pipeline-utils@feat-test') _

pipeline {
  agent any
  tools {
          maven 'maven3.9.4'
  }
  stages {
    stage('Cloning') {
        steps {
          git branch: 'develop',
          credentialsId: 'jenkins-ec2',
          url: 'https://github.com/mandinga27/curso-kubernetes.git'

          script {
		        try {
              // send build started notifications
        		  slackSend (channel: "#jenkins-notifications", color: '#00FF00', message: "Ejecucion : ${env.BUILD_NUMBER} Comenzando! En el primer Stage. ${env.BUILD_URL}")
			        //sh "Stage exitoso: notificacion Slack"
		        }
	          catch(Exception e) {
		          bat 'echo "Job Failed"'
		          currentBuild.result = "FAILURE"
		          slackSend (channel: "#jenkins-notifications", color: '#FF0000', message: "Ejecucion : ${env.BUILD_NUMBER} FAILED! Hubo un error! ${env.BUILD_URL}")
              //sh "Stage con error: notificacion Slack"
            }
        }
      }
      /*
      stage('Clone SCM for sonar') {
        steps {
          // Clean before build
          cleanWs()
          git branch: 'deploy2',
            credentialsId: '43f6a5b8-4620-4750-b989-bebbc9aa42f4',
            url: 'https://github.com/mandinga27/react-backend.git'
        }
      }
      */
    }
    stage('Build') {
        steps {
            withMaven(maven: 'mvn') {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                succes {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
    stage('sonar Cloud') {
        steps {
          withSonarQubeEnv(installationName: 'sonar-cloud') {
            sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.4:sonar'
          }
        }
    }
    stage("Quality Gate") {
      steps {
        timeout(time: 1, unit: 'MINUTES') {
          waitForQualityGate abortPipeline: true
          }
      }
    }

    stage('prueba library') {
      steps{
        script{
         hola()
        }
      }
    }
  }
}