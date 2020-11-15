# Covid-Tracker
Java Assignment 4

The figure illustrates people moving in a space of 30x30 meters. The people, represented by the
stars, start up in the space at random locations, and follow what is called a Random Waypoint
mobility model to walk around. The lifetime of the entire walk is 60 seconds, after which the
program halts. You initially have 30 people in the space, and 3 of them are COVID positive. Each
node moving around is a thread of its own.
The random waypoint is simply described as follows: Each node waits a random amount of
time, which you can assume here to be in [500 ms, 1000 ms] The node then picks a random
direction to move to (you can consider that there are 8 directions to move to, N, E, W, S, and
diagonals). The node then moves to that direction. Each move is a 1 meter move. The node
then repeats its motion again by waiting a random amount of time, then making the move.
Each time a node moves, its new location should be updated in the window as shown. You do
not need to keep track of the red arrows.
At any point in time, nodes can be within an “unsafe social distance” for a duration of time. The
safe social distance is 1 meter by default. If the nodes spend more than 2 seconds within the
“unsafe social distance” of a COVID positive, they are flagged for possible infection. There is no
second degree infection for simplicity (i.e. a node cannot be infected from one of the COVID
positives and infect others).
All nodes are initially blue. The COVID positives are red, and the ones flagged for infection
become orange once the criteria is met. 

For this program, you need to parametrize it to include the following (the defaults are listed
above).
- The X and Y coordinate of the space.
- The number of nodes in the space.
- The percentage of nodes that are COVID positive.
- The total length of the walk.
- The range of time to randomly wait (min milliseconds to max milliseconds)
- The distance to move each time.
- The safe social distance.
- The amount of time to remain in the unsafe social distance to be infected.
You can select the values above using a slider where applicable to verify the inputs better. You
can make valid assumptions.
As you can see, throughout the simulation, the nodes change colors as they get infected. You
need to print out at the end of the simulation which nodes are flagged for infection, and try it
out with different parameters. 
