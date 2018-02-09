#!/usr/bin/env groovy

node {
	
    properties([
        pipelineTriggers([
            [$class: 'GenericTrigger',
                genericVariables: [
                    [expressionType: 'JSONPath', key: 'reference', value: '$.ref'],
                    [expressionType: 'JSONPath', key: 'before', value: '$.before'],
                    [expressionType: 'JSONPath', key: 'after', value: '$.after'],
                    [expressionType: 'JSONPath', key: 'repository', value: '$.repository.full_name']
                ],
                genericRequestVariables: [
                    [key: 'requestWithNumber', regexpFilter: '[^0-9]'],
                    [key: 'requestWithString', regexpFilter: '']
                ],
                genericHeaderVariables: [
                    [key: 'headerWithNumber', regexpFilter: '[^0-9]'],
                    [key: 'headerWithString', regexpFilter: '']
                ],
                regexpFilterText: '$repository/$reference',
                regexpFilterExpression: 'GMS/vol/refs/heads/master'  // Git에 있는 조직그룹/저장소명 (GMS/vol)
            ]
        ])
    ])


    stage('Checkout') {
        checkout scm
    }

    stage('Test') {
        sh './gradlew test || true'
    }

    stage('Build') {
        try {
            sh './gradlew clean build'
            archiveArtifacts artifacts: '**/build/libs/*.war', fingerprint: true
        } catch(e) {
            mail subject: "Jenkins Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) failed with ${e.message}",
                to: 'mjskyroom@sicc.co.kr',
                body: "Please go to $env.BUILD_URL."
        }
    }

    stage('Push') {
        try {
            sh './gradlew dockerPush'
            archiveArtifacts artifacts: '**/build/libs/*.war', fingerprint: true
        } catch(e) {
            mail subject: "Jenkins Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) Push failed with ${e.message}",
                to: 'mjskyroom@sicc.co.kr',
                body: "Please go to $env.BUILD_URL."
        }
    }
    
    stage('Deploy') {
        sh 'kubectl apply -f deployment.yaml'
    }    
}