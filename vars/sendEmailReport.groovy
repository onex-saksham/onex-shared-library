def call(String recipients) {
    echo "Sending email report to: ${recipients}"

    emailext(
        to: recipients,
        subject: "Jenkins Build: ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${currentBuild.currentResult}",
        body: '${SCRIPT, template="custom-report.template"}',
        mimeType: 'text/html',
        attachLog: (currentBuild.currentResult != "SUCCESS")
    )
}
