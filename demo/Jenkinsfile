pipeline {
   agent any

   stages {
       stage ('Compile Stage') {

           steps {
               withMaven(maven : 'maven_3_6_0') {
                   sh 'mvn clean compile'
               }
           }
       }
        stage ('Build Stage') {

           steps {
               withMaven(maven : 'maven_3_6_0') {
                   sh 'mvn install'
               }
           }
       }

         stage ('Testing Stage') {

           steps {
               withMaven(maven : 'maven_3_6_0') {
                   sh 'mvn test'
               }
           }
       }
         stage('Build Image'){
              steps{
               sh 'sudo docker build -t ravijaydev/demo-app:${BUILD_NUMBER} .'
              sh 'docker tag ravijaydev/demo-app:${BUILD_NUMBER} ravijaydev/demo-app:latest'
              
                }
         }
        stage('Push Image'){
         steps{
               sh 'docker login -u ravijaydev -p raviravi'
                sh 'docker push ravijaydev/demo-app:${BUILD_NUMBER}'
               sh 'docker push ravijaydev/demo-app:latest'
                
                }    
                  
   }
    
         stage('Force Deploy') {
        steps{
               sh 'aws ecs update-service --region us-east-1 --cluster Ravi-SpringBoot --service raviservice --force-new-deployment'
            }
    }
    
         stage('Remove Image from Server') {
        steps{
               sh 'docker image rm ravijaydev/demo-app:latest'
            }
    }
 }
}