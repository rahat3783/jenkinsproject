pipeline {
    agent any 
    tools {
        maven "mvn"
    
    }
    stages {
         stage('Code clonning') { 
            steps {
            
            git url: "https://github.com/rahat3783/jenkinsproject.git",branch:"main"      
        
            }
        }
        stage('Compile and Clean') { 
            steps {
                // Run Maven on a Unix agent.
              
                sh "mvn clean compile"
            }
        }
        stage('mvn deploy') { 
            
            steps {
                sh "mvn package"
            }
        }
        stage('Build Docker image'){
          
            steps {
                echo "Hello Java Express"
                sh 'ls'
                sh 'docker build -t  demospringapp:latest .'
            }
        
        }
        stage('push image to Dockerhub'){
            steps{
                echo "pushing image to dockerhub"
               withCredentials([usernamePassword(
                    'credentialsId':"dockercred",
                    passwordVariable: "dockerpass",
                    usernameVariable: "dockeruser")]){
                 sh "docker login -u ${env.dockeruser} -p ${env.dockerpass}"
                 sh "docker image tag demospringapp:latest champ3783/demospringapp:latest"
                 sh "docker push champ3783/demospringapp:latest"
                }
                }
        }
       
        stage('Docker deploy'){
            steps {
               
                sh 'docker compose up -d'
            }
        }
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
