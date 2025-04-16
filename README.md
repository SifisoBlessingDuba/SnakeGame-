# SnakeGame-
this is a recreation of the old snake game using java GUI and and different classes 
The game was completed using only Java and it contains 3 classes in total.
  the main class with PSVM method which has the instance of the GameFrame class.
  It contains the GameFrame Class which has an instance of  the GamePanel class and uses JFrame to create the GUI to display the game.
  It also contains the GamePanel class that has all almost all the code of the Game including logic and variable declarations. 

The purpose of the code was for me to refresh on GUI in java as well as basics such as switch cases. 
This code uses the arrow buttons to control the movement of the snake even though i tried to get it to use the "WASD" keys that most gamers are use to, it won't listern to those keys only the arrow buttons register. 
The code includes Java classes an interfaces such as JPanel, JFrame to display the game and action listener to register user inputs.
the code also has different methods for different reasons in the GamePanel class such as:
   startGame() to start the game using the GUI displayed, 
   paintComponent(Graphics g) which calls the paintComponent method and the calls the draw() method.
   Draw() method is the one responcible for all the components and colors and fontsof the game in the GUI, that is if the game is still going then when the game is over it class the gameOver() method.
   newApple() method that creates the apple in random parts of the screen limited by the barrier of the screen high and width.
   move() method is responsible for the movement of the Snake and also uses a switch statement to depict the movement direction of the snakes
   checkApple() method then hecks if the apple has been eaten using the index, then if yes it will increase the Snake's body by 1 and the applesEaten by 1 wich the results in the score of the player increasing, so        with each apple eatern the score grows by 1.
   CheckCollisions() method is the method used to check the if the snake has collided with either the barrier or itself and if yes it will stop the timer of the game.
   gameOver(Graphics g) is the method that then displays the "Game over" screen with the score on top after the player killed the snake.
   ActionPerfomred() method then uses the user's input to direcdt the Snake away from the barriers and towards the apple, it calls the move, checkApple and checkCollision to methods to make sure the game is still on      and the actions are registered in game. If the game is over then it will repaint the screen which means that the game will then restart, It also has a switch case that are under the keyPressed() method and it sets     a direction for each key specified and also stops the Snake from moving over a 90 degrees angle. 

Key takeaways from this Code
what i learned during this code self made project was that the are different ways to call a GUI to the main class rather than the method i was tought in school. 
I also got s chance to revisit the simple part of java with switch cases that i last used in first year.
It gave me insight into new features in java i didn't know or never used before such as the KeyPassed() method, the Graphics class, the Timer class and the Random class.


NB: i hope this project brings as mmuch joy and insparation to you as it did to me :), it made me feel motivated and ready to learn more and i plan on doing more project like this at least once every two weeks or a month.
 
 
 
 
