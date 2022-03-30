pipeline {
    environment {
        registry = "karthikeyanr4java/shutterbug"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    agent any
 /*   agent {
        label: 'docker-maven-slave'
    } */
    tools {
        maven 'maven'
    }
    stages {
        stage('Sample') {
            steps {
                bat 'echo "Hi"'
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage('Push To Artifactory') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}