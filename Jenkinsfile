pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                // This checks out code from your Git repo
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                bat 'mvn clean install'
            }
        }
    }

    post {
        success {
            echo '✅ Build succeeded!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}