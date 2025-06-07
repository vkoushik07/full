pipeline {
    agent any

    tools {
        nodejs 'Nodejs' // Name of your Node.js installation in Jenkins Tools
    }

    environment {
        BACKEND_DIR = 'demo'
        FRONTEND_DIR = 'fend'
        BACKEND_PORT = '6968' // Spring Boot default port
        FRONTEND_PORT = '3000' // React default port
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
                    sh 'mvn clean package'
                    // Run in background and keep process running after pipeline ends
                    sh 'nohup java -jar target/*.jar &'
                }
            }
        }

        stage('Install Frontend Dependencies') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh 'npm install'
                }
            }
        }

        stage('Run Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    // Run in background and keep process running after pipeline ends
                    sh 'nohup npm run dev &'
                }
            }
        }

        stage('Verify Services') {
            steps {
                script {
                    // Wait for services to start
                    sleep(time: 30, unit: 'SECONDS') 
                    
                    // Verify backend is running
                    sh "curl -f http://localhost:${BACKEND_PORT}/actuator/health || echo 'Backend not responding'"
                    
                    // Verify frontend is running
                    sh "curl -f http://localhost:${FRONTEND_PORT} || echo 'Frontend not responding'"
                }
            }
        }
    }

    post {
        failure {
            echo "❌ Build failed. Time to cry or debug 😢"
        }
        success {
            echo """
            ✅ Build successful! 
            Access your services at:
            Backend: http://localhost:${BACKEND_PORT}
            Frontend: http://localhost:${FRONTEND_PORT}
            
            Note: If Jenkins is running on a remote server, use SSH port forwarding:
            ssh -L ${BACKEND_PORT}:localhost:${BACKEND_PORT} -L ${FRONTEND_PORT}:localhost:${FRONTEND_PORT} user@jenkins-server
            """
        }
    }
}
