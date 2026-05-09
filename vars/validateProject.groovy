#!/usr/bin/env groovy

/**
 * validateProject — Checks that required project files exist.
 *
 * Usage in Jenkinsfile:
 *     validateProject(requiredFiles: ['project.json', 'README.md', 'app/index.html'])
 */
def call(Map config = [:]) {
    // Get the list of required files, or use defaults
    def requiredFiles = config.requiredFiles ?: ['project.json', 'README.md']

    echo "--- Validating project structure ---"

    def allPassed = true

    for (String file in requiredFiles) {
        def exists = fileExists(file)
        if (exists) {
            echo "PASS: ${file} found"
        } else {
            echo "FAIL: ${file} MISSING"
            allPassed = false
        }
    }

    if (!allPassed) {
        error "Project validation failed — one or more required files are missing"
    }

    echo "All required files present!"
}
