pipeline {
  agent any
  tools {
    maven '3.8.1'
  }
  stages {
    stage('Maven Build') {
      steps {
        sh 'mvn --version'
        //sh 'maven clean verify'
      }
    }
    /*
    stage('Veracode Pipeline Scan') {
      steps {
        sh 'curl -O https://downloads.veracode.com/securityscan/pipeline-scan-LATEST.zip'
        sh 'unzip pipeline-scan-LATEST.zip pipeline-scan.jar'
        sh 'java -jar pipeline-scan.jar \
          --veracode_api_id "077f7b5e714fd283f45775322fe97131" \
          --veracode_api_key "1e1e28b713888d239260989ddab340aff8162f5c462a42c4dbf40d109eabfeba2968e1785c76e7fab6cca9e55db0c5ca55ac2172c0b62b7626957ed78e1bcb96" \
          --file "/app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar" \
          --fail_on_severity="Very High, High" \
          --fail_on_cwe="80" \
          --baseline_file "${CI_BASELINE_PATH}" \
          --timeout "${CI_TIMEOUT}" \
          --project_name "${env.JOB_NAME}" \
          --project_url "${env.GIT_URL}" \
          --project_ref "${env.GIT_COMMIT}"'
      }
    }
    stage('Store Baseline') {
            steps {
                script {
                    try {
                        //input(message: 'Store results as baseline for future scans?', ok: 'Yes')
                        sh 'cp baseline.json build-baseline.json'
                        sh 'cp results.json baseline.json'
                    } catch (err) {

                    }
                }
            }
        }
        */

  }
  /*
  post {
    always {
      archiveArtifacts artifacts: 'results.json', fingerprint: true
    }
  }
  */
}