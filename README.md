# Othello
A board game played on a 8X8 board with black and white pieces.

This is a user interactive version of Othello using a Graphical User Interface.

Here is a link to how to learn how play Othello:
https://www.ultraboardgames.com/othello/game-rules.php

The user plays against an AI player that chooses its next best move based on where the user's disks are. The AI player makes their next move by choosing the spot that will change the most pieces' color(to their advantage).

In order to play against the computer, the user must select a viable spot on the board or else nothing will happen. The user will continue to play against the computer until there are no possible moves. Once the game is over, the board will fill up with the pieces of the color of the winner.



HOW DO I USE THIS?
In order to Compile this code, you have to run it in eclipse or another Java IDE since it is all coded in Java. Make sure to run the main method ('MyOthello') for the code to begin or else it won't compile.

OPTIMAL DESIGN CHOICES
In order to make the Code for this project cleaner, I split it up into several classes which I could conceptualize easier. I had 'MyOthello' class which brought all my classes together, I had my 'Square' class which created the squares of the gameboard, I had a 'GameBoard' class which was where I created my Graphical User Interface and Repainted after each move, I had my 'GameMouseListener' class which implemented the MouseListener class that told me where exactly on the screen was clicked, and lastly I had my 'ComputerPlayer' class which scoped through each open spot on the board and 1) checked if it was a viable spot and 2) checked if it was the optimal move to make.



