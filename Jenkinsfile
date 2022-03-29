pipeline {
    environment {
        registry = "karthikeyanr4java/shutterbug"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    agent any
 /*   agent {
        label: 'docker-maven-slave'
    }
    tools {
        maven 'maven-mixin'
    } */
    stages {
        stage('Build & Test') {
            step {
                sh 'mvn clean install'
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