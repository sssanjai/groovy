def gitConfigFile = new File(System.getProperty("user.home"), ".gitconfig")

if (gitConfigFile.exists()) {
    println "--- Before Modification ---"
    println gitConfigFile.text
    
    def updatedContent = gitConfigFile.text.replaceAll(/(?<=\[user\]\s*.*\n\s*name\s*=\s*)melvin/, "nb13886")
    
    if (updatedContent != gitConfigFile.text) {
        gitConfigFile.text = updatedContent
        println "\n--- After Modification ---"
        println gitConfigFile.text
    } else {
        println "\nNo matching username 'melvin' found in .gitconfig."
    }
} else {
    println ".gitconfig file not found in the user's home directory."
}
