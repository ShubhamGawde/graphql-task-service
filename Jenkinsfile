pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3.8'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-user/your-spring-boot-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests -Dspring.profiles.active=prod'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -Dspring.profiles.active=prod'
            }
        }

        stage('Deploy') {
            steps {
                // Run your Spring Boot app with the prod profile
                sh 'java -jar target/task-service.jar --spring.profiles.active=prod'
            }
        }
    }
}
