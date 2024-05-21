This program is designed to be run after compiling all related .java files, and then running the Deadwood file.

The way I did this during testing was executing "javac *.java" from the directory that stores the .java files, and then executing "java Deadwood", but it may vary from terminal to terminal and on your machine. Any way you have that can compile the Files and run Deadwood should work.

The program supplies a string of prompts, and figuring out how to use it should be relatively simple. There are no commandline arguments, the game will simply prompt you for a number of Players as the first part of execution.

The prompts don't outline the rules or the goal of the game, but using a copy of the rules and the prompts the program gives you should allow for a seamless playthrough of the game as the rules intend it.

We designed it so that the game will only prompt you for the actions you are legally allowed to take, and therefore the user should not have to fear breaking the rules.

The game will complete in the same conditions given by the rules, or execution can be stopped by any normal interrupt command. (It's not a prompt, but you can also quit by entering q at the beginning of any player's turn, or trigger the end of the game immediately by entering `).

I hope the code is up to par and you can enjoy!