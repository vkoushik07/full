
pipeline {
    agent any

    environment {
        BACKEND_DIR = 'demo'
        FRONTEND_DIR = 'fend'
        NODE_PATH = '/home/venkat-koushik/.nvm/versions/node/v22.15.1/bin/node'

        NPM_PATH = '/home/venkat-koushik/.nvm/versions/node/v22.15.1/bin/npm'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/vkoushik07/full.git'
            }
        }

        stage('Build & Run Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Install Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh "${NPM_PATH} install"
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh "${NPM_PATH} run dev"
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
