# Find the 10x developer
A solution to ThoughtWorks Australia shokunin coding challenge, August 2019 edition.

Here's what we know:
* Jessie is not the best developer
* Evan is not the worst developer
* John is not the best developer or the worst developer
* Sarah is a better developer than Evan
* Matt is not directly below or above John as a developer
* John is not directly below or above Evan as a developer

## The challenge
* Who is the 10x developer on the team?
* What is the correct ordering of the members of the team according to their coding skills?

## Dependencies
Make sure the following dependencies are installed and available on $PATH.

* GNU Prolog, from [http://gprolog.org/#download](http://gprolog.org/#download).
* Java 11
* Gradle

## The solution
* Run ```./go```

If all goes well, the solution should print on screen:

```
➜  shokunin-august-2019 git:(master) ./go
GNU Prolog 1.4.5 (64 bits)
Compiled Jul 14 2018, 16:25:15 with /usr/bin/clang
By Daniel Diaz
Copyright (C) 1999-2018 Daniel Diaz
compiling /Users/kevinyeung/workspaces/shokunin-august-2019/10x_dev.pl for byte code...
/Users/kevinyeung/workspaces/shokunin-august-2019/10x_dev.pl compiled, 12 lines read - 1603 bytes written, 7 ms
| ?- devs([Evan, Jessie, John, Matt, Sarah]).

Evan = 4
Jessie = 3
John = 2
Matt = 5
Sarah = 1 ? a

no
| ?-

➜  shokunin-august-2019 git:(master)
```

Congratulations, Sarah.

