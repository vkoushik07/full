pipeline {
  agent any
 tools{
nodejs "Nodejs"
 }
  stages {
    stage('Clone Repo') {
      steps {
       git branch: 'main', url: 'https://github.com/vkoushik07/full.git'
      }
    }

    stage('Build Backend') {
      steps {
        dir('demo') {
          sh 'mvn clean package -DskipTests'
        }
      }
    }

    stage('Build Frontend') {
      steps {
        dir('fend') {
          sh 'npm install'
          sh 'npm run build'
        }
      }
    }

    stage('Docker Compose Up') {
      steps {
        sh 'docker-compose down || true' // Stop any existing containers
        sh 'docker-compose up --build -d' // Rebuild and run containers
      }
    }

    stage('Verify') {
      steps {
        sh 'docker ps' // Show running containers in logs
      }
    }
  }
}
