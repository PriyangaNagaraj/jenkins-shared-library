#!/usr/bin/env groovy

/**
 * codeStats — Prints line counts and file statistics.
 *
 * Usage in Jenkinsfile:
 *     codeStats()
 */
def call() {
    echo "--- Code Statistics ---"
    sh '''
        echo "Total files: $(find . -type f -not -path './.git/*' | wc -l)"
        echo "HTML files:  $(find . -name '*.html' | wc -l)"
        echo "MD files:    $(find . -name '*.md' | wc -l)"
        echo "JSON files:  $(find . -name '*.json' | wc -l)"
    '''
}
