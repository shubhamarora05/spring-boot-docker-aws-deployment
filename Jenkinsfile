pipeline {
    agent any

	environment {
	    PATH = "PATH-TO-DOCKER"
	    registry = "DOCKER-HUB-REGISTRY" 
        registryCredential = 'DOCKER-HUB-CREDENTIALS-ID' 
        dockerImage = ''
        DOCKER_HOST = "DOCKER-HOST-IP"
	}
	
	tools {
		maven "maven"
	}
	
    stages {
        stage("Compile") {
            steps {
                bat "mvn clean compile"
            }
        }
        stage("Test") {
            steps {
                bat "mvn test"
            }
        }
        stage("Install") {
            steps {
                bat "mvn install -DskipTests"
                bat "cd PATH-WHERE-JAR-FILE-IS-LOCATED"
            }
        }
        stage("Docker Image Build") {
            steps {
                script {
	                docker.withServer(DOCKER_HOST) { 
	                	dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    }
                }
            }
        }
       stage('Push image To Hub') { 
            steps { 
                script { 
                    docker.withServer(DOCKER_HOST) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
        stage('Start Container') { 
            steps {
	            script { 
	                    docker.withServer(DOCKER_HOST) { 
	                        bat "docker run -d -p 8070:8070 $registry:$BUILD_NUMBER"
	                    }
	            } 
            }
        }
    }
}