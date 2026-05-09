#!/usr/bin/env groovy

/**
 * notifyBuild — Prints a build status summary.
 *
 * Usage in Jenkinsfile:
 *     notifyBuild(status: 'SUCCESS')
 *     notifyBuild(status: 'FAILURE')
 */
def call(Map config = [:]) {
    def status = config.status ?: 'UNKNOWN'
    def branch = env.BRANCH_NAME ?: 'N/A'
    def buildNum = env.BUILD_NUMBER ?: 'N/A'

    echo "============================================"
    echo "  BUILD RESULT: ${status}"
    echo "  Branch: ${branch}"
    echo "  Build:  #${buildNum}"
    echo "============================================"

    if (status == 'FAILURE') {
        echo "⚠️  Check the Console Output above for errors."
    }
}
