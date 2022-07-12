package stage2

import java.io.File

const val CONFIG_FILE_NAME = "./vcs/config.txt"
const val INDEX_FILE_NAME = "./vcs/index.txt"

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        printHelp()
        return
    }

    when (val command = args[0]) {
        "--help" -> printHelp()
        "config" -> if (args.size == 1) config() else config(args[1])
        "add" -> if (args.size == 1) add() else add(args[1])
        "log" -> println("Show commit logs.")
        "commit" -> println("Save changes.")
        "checkout" -> println("Restore a file.")
        else -> println("'$command' is not a SVCS command.")
    }
}

// only 'config' has been entered, no new username
// we just read the username from the config file
fun config() {
    val username = getConfigFile().readText()
    if (username.isEmpty()) {
        println("Please, tell me who you are.")
    } else {
        println("The username is $username.")
    }
}

// 'config newUsername' has been entered,
// 'newUsername' will overwrite username in configFile
fun config(newUsername: String) {
    getConfigFile().writeText(newUsername)
    println("The username is $newUsername.")
}

// only 'add' has been entered, no new file
// we list the files that are listed in the index
fun add() {
    val indexedFiles = getIndexFile().readLines()
    if (indexedFiles.isEmpty()) {
        println("Add a file to the index.")
    } else {
        println("Tracked files:")
        indexedFiles.forEach { println(it) }
    }
}

// 'add newFile' has been entered
// check if new file exists and append this file to index
fun add(newFile: String) {
    if (File(newFile).exists()) {
        getIndexFile().appendText(newFile + '\n')
        println("The file '$newFile' is tracked.")
    } else {
        println("Can't find '$newFile'.")
    }
}

fun getConfigFile(): File {
    return getFile(CONFIG_FILE_NAME)
}

fun getIndexFile(): File {
    return getFile(INDEX_FILE_NAME)
}

// get the File, create it if it does not exist
fun getFile(fileName: String): File {
    val file = File(fileName)
    if (!file.exists()) {
        file.parentFile.mkdirs()
        file.createNewFile()
    }
    return file
}

fun printHelp() {
    println("These are SVCS commands:")
    println("config     Get and set a username.")
    println("add        Add a file to the index.")
    println("log        Show commit logs.")
    println("commit     Save changes.")
    println("checkout   Restore a file.")
}