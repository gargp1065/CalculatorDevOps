pipeline {
    agent any

    stages {
        stage('Step 1: Git clone') {
            steps {
                git url: 'https://github.com/gargp1065/CalculatorDevOps.git',
				branch: 'main',
                credentialsId: 'github'
            }
        }
        stage('Step2 : Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Step3 : Maven Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Step4: Build docker Image') {
            steps {
                sh 'docker build -t gargp1065/calculator-devops:latest .'
            }
        }
        stage('Step 5: Publish Docker images to dockerhub') {
            steps {
                withDockerRegistry([ credentialsId: "dockerhub", url: "" ]) {
                    sh 'docker push gargp1065/calculator-devops:latest'
                }
            }
        }
        stage('Step 6: Clean Docker Image') {
            steps {
                sh 'docker rmi -f gargp1065/calculator-devops:latest'
            }
        }

        stage('Stage 7: Deploy and Run Image'){
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'p2.yml', sudoUser: null
            }
        }
    }
}