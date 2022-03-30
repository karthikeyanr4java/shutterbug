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
        maven 'MAVEN_HOME'
    }*/
    stages {
        stage('Sample') {
            steps {
                sh 'echo "Hi"'
            }
        }
        stage('Build & Test') {
            steps {
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