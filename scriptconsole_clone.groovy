def workspaceDir = new File("/home/jenkins/workspace/ota-conti/deploy-pipeline/backend-gcp-deploy")
def gitCloneCommand = "git clone git@git.elektrobitautomotive.com:EB-EST-COS-A-4/ota-backend-services.git"

if (!workspaceDir.exists()) {
    workspaceDir.mkdirs()
}

def process = new ProcessBuilder("sh", "-c", gitCloneCommand)
    .directory(workspaceDir)
    .redirectErrorStream(true)
    .start()

process.inputStream.eachLine { line ->
    println line
}

int exitCode = process.waitFor()
println "Command exited with code: $exitCode"
