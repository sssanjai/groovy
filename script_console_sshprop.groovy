def userHome = System.getProperty("user.home")
def sshDir = new File(userHome, ".ssh")
def gitConfigFile = new File(userHome, ".gitconfig")

println "User Home Directory: ${userHome}"

// List SSH public keys
println "\n--- SSH Public Keys ---"
if (sshDir.exists()) {
    sshDir.listFiles().findAll { it.name.endsWith(".pub") }.each { pubKey ->
        println "\nPublic Key: ${pubKey.name}"
        println pubKey.text
    }
} else {
    println "SSH directory does not exist."
}

// Show SSH config
println "\n--- SSH Config ---"
def sshConfigFile = new File(sshDir, "config")
if (sshConfigFile.exists()) {
    println sshConfigFile.text
} else {
    println "No SSH config file found."
}

// Show .gitconfig
println "\n--- .gitconfig ---"
if (gitConfigFile.exists()) {
    println gitConfigFile.text
} else {
    println "No .gitconfig file found."
}
