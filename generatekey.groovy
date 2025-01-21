def sshKeyPath = new File(System.getProperty("user.home"), ".ssh/id_rsa_workaround")

// Check if the key already exists
if (sshKeyPath.exists()) {
    println "SSH key already exists at: ${sshKeyPath}"
} else {
    println "Generating SSH key at: ${sshKeyPath}"

    // Create the .ssh directory if it does not exist
    def sshDir = new File(System.getProperty("user.home"), ".ssh")
    if (!sshDir.exists()) {
        sshDir.mkdirs()
    }

    // Command to generate the SSH key
    def sshKeygenCommand = "ssh-keygen -t rsa -b 4096 -C 'sanjaivasan.ss@elektrobit.com' -f ${sshKeyPath} -N ''"
    
    // Execute the command
    def process = new ProcessBuilder("sh", "-c", sshKeygenCommand)
        .redirectErrorStream(true)
        .start()

    // Capture the output
    process.inputStream.eachLine { line ->
        println line
    }

    int exitCode = process.waitFor()
    println "Key generation completed with exit code: $exitCode"
    if (exitCode == 0) {
        println "SSH key generated successfully: ${sshKeyPath}.pub"
    } else {
        println "Error generating SSH key."
    }
}
