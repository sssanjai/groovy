def commands = [
    "git config --get user.name",
    "git config --get user.email",
    "git config --list"
]

commands.each { command ->
    def process = new ProcessBuilder("sh", "-c", command)
        .redirectErrorStream(true)
        .start()

    println "\nCommand: $command"
    process.inputStream.eachLine { println it }
    process.waitFor()
}
