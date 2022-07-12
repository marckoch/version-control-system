package stage1

fun main(args: Array<String>) {
    if (args.size != 1) {
        printHelp()
        return
    }

    when (val input = args[0]) {
        "--help" -> printHelp()
        "config" -> println("Get and set a username.")
        "add" -> println("Add a file to the index.")
        "log" -> println("Show commit logs.")
        "commit" -> println("Save changes.")
        "checkout" -> println("Restore a file.")
        else -> println("'$input' is not a SVCS command.")
    }
}

fun printHelp() {
    println("These are SVCS commands:")
    println("config     Get and set a username.")
    println("add        Add a file to the index.")
    println("log        Show commit logs.")
    println("commit     Save changes.")
    println("checkout   Restore a file.")
}