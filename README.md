# Jetbrains Academy - Version Control System

My solutions for the Jetbrains Academy Problem 'Version Control System'

https://hyperskill.org/projects/177

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are four stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/177/stages/909/implement)

Just display a usage info about all possible commands for our little SVCS.

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain
    
    These are SVCS commands:
    config     Get and set a username.
    add        Add a file to the index.
    log        Show commit logs.
    commit     Save changes.
    checkout   Restore a file.

## Stage 2

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/177/stages/910/implement)

Commands 'add' and 'config' have been added.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain --args='add file1'
    
    Cant find 'file1'.

    gradle -PmainClass=stage2.MainKt run --console=plain --args='config username'

    The username is username.

## Stage 3

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/177/stages/911/implement)

Commands 'commit' and 'log' have been added.

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain

## Stage 4

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/177/stages/912/implement)

Command 'checkout' has been added.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain
