def gitConfigFile = new File(System.getProperty("user.home"), ".gitconfig")

if (gitConfigFile.exists()) {
    println "--- Before Modification ---"
    println gitConfigFile.text

    // Replace username
    def updatedContent = gitConfigFile.text.replaceAll(/(?<=\[user\]\s*.*\n\s*name\s*=\s*)melvin/, "nb13886")

    // Replace email (modify 'melvin@example.com' and 'nb13886@example.com' as needed)
    updatedContent = updatedContent.replaceAll(/(?<=\[user\]\s*.*\n\s*email\s*=\s*)melvin@example\.com/, "nb13886@example.com")
    
    if (updatedContent != gitConfigFile.text) {
        gitConfigFile.text = updatedContent
        println "\n--- After Modification ---"
        println gitConfigFile.text
    } else {
        println "\nNo matching username 'melvin' or email 'melvin@example.com' found in .gitconfig."
    }
} else {
    println ".gitconfig file not found in the user's home directory."
}
