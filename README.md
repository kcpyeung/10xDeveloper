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

## The solution

* Download and install GNU Prolog from [http://gprolog.org/#download](http://gprolog.org/#download).
* Add ```gprolog``` to PATH.
* Run ```./go```

If all goes well, the solution should print on screen:


```
➜  shokunin-august-2019 ./go
GNU Prolog 1.4.5 (64 bits)
Compiled Jul 14 2018, 16:25:15 with /usr/bin/clang
By Daniel Diaz
Copyright (C) 1999-2018 Daniel Diaz
compiling /Users/kevinyeung/workspaces/shokunin-august-2019/10x_dev.pl for byte code...
/Users/kevinyeung/workspaces/shokunin-august-2019/10x_dev.pl compiled, 19 lines read - 1803 bytes written, 6 ms
| ?- devs([Jessie, Evan, John, Sarah, Matt]).

Evan = 4
Jessie = 3
John = 2
Matt = 5
Sarah = 1 ? a

(1 ms) no
| ?-

➜  shokunin-august-2019
```

Congratulations, Sarah.

