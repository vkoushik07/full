pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // Clones the latest repo content
                git 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Run Backend') {
            steps {
                dir('backend') {
                    sh 'mvn spring-boot:run &'
                }
            }
        }

        stage('Install Frontend') {
            steps {
                dir('frontend') {
                    sh 'npm install'
                }
            }
        }

        stage('Run Frontend') {
            steps {
                dir('frontend') {
                    sh 'npm run dev'
                }
            }
        }
    }
}
