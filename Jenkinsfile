pipeline {
    agent any

    environment {
        BACKEND_DIR = 'demo'
        FRONTEND_DIR = 'fend'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // This clones the entire repo including Jenkinsfile
                git branch: 'main', url: 'https://github.com/vkoushik07/full.git'
            }
        }

        stage('Build & Run Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    sh 'mvn clean install'
                    // Run Spring Boot (optional, usually done only in deploy stage)
                    // sh 'mvn spring-boot:run'
                }
            }
        }

        stage('Install Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh 'npm install'
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh 'npm run dev'  // Or `npm start` or `npm run dev` depending on your app
                }
            }
        }
    }

    post {
        failure {
            echo "❌ Build failed. Time to cry or debug 😢"
        }
        success {
            echo "✅ Build successful. Go grab chai ☕"
        }
    }
}

