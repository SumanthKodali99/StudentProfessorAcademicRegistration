library 'reference-pipeline'
library 'AppServiceAccount'

pipeline {
    agent { /* Build Node details */ }
    environment {
        APPNAME = "AcademicCourseRegistration"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    triggers {
        gitlab(
                triggerOnPush: true
        )
    }


    tools {
        jdk 'JAVA_8'
    }

    stages {
        stage('Initialize') {
            steps {
                script {
                    APP_VERSION = getApplicationProperty property: 'version'
                    APP_GROUP = getApplicationProperty property: 'group'
                    println "App version is ${APP_VERSION}"
                    println "Group is ${APP_GROUP}"
                }
            }
        }

        stage('build') {
            when {
                anyOf {
                    branch 'development'
                    branch 'master'
                }
            }
            steps {
                sh 'chmod 775 gradlew'
                sh './gradlew clean build jacocoTestReport'
            }
            post {
                success {
                    junit 'build/test-results/**/*.xml'
                    jacoco(
                            skipCopyOfSrcFiles: true,
                    )
                }
            }
        }

        stage('Sonarqube scan') {
            when {
                anyOf {
                    branch 'development'
                    branch 'master'
                }
            }
            steps {
                script {
                    def scannerHome = tool 'SonarQube_Scanner';
                    withSonarQubeEnv('SonarQube') {
                        sh "${scannerHome}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                    }
                }
            }
        }


        stage('Deploy to Cloud') {
        }
    }
}