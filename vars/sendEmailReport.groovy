def call(Map config = [:]) {

    def recipient = config.get('to', 'saksham.jain@onextel.com')
    def template = config.get('template', 'custom-report.template')

    echo "Sending email summary report from Shared Library..."

    emailext(
        to: recipient,
        subject: "Jenkins Pipeline: ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${currentBuild.currentResult}",
        body: '${SCRIPT, template="custom-report.template"}',
        mimeType: 'text/html',
        verbose: false
    )
}
