# BRICK DESTROYER

------------------------------------------------------------------------------------------------------------------------------------------------------------
##REFACTOR



###Organizing Into Meaningful Packages

Moving the classes into separate packages allows the programmer to be more organized. In my case I placed the classes into new packages 
based on the functions they perform. I have 3 package, and they are **highscore**, **main**, and **parts**.

| **Packages** | **Classes** |
| ----------- | ----------- |
| highscore | HighScore, Score, ScoreCompare|
| main | DebugConsole, DebugPanel, GameBoard, GameFrame, GraphicsMain, HomeMenu, ImageLoader, Levels, Player, Wall |
| parts | Ball, Brick, Crack, CementBrick, ClayBrick, DiamondBrick, RubberBall, SteelBrick, TitaniumBrick |

###Basic Maintenance 

1. I took the **Wall** class and removed the level creation and level making methods. I made a new class that handles the level creation called, **Levels** .
This allowed me to read and make changed to the code later on when adding additional levels easier and faster.
   
   
2. I did some code clean-up here and there and scraped the codes that weren't being used. I remade the **HomeMenu** class and kept non of the old code. Therefore,
I did not need any of the old codes. Another example being, a bunch of libraries imported but not called were scraped and a variables that have moved elsewhere were 
   also scraped.
   

------------------------------------------------------------------------------------------------------------------------------------------------------------
##ADDITION



###Permanent High-score List

I created a **HighScore** class that handles the high-score list that will take the score of the player at the end of the game and save it into a file. It will then 
sort the .dat file and only display 10 high scores. The score will increment when the 'brickCount-- ' in the **Wall** class. It will also display the player's current 
score while in game.

###Additional Playable Levels

I added more brick types for higher levels in the game. **DiamondBrick** would are the strongest, and it takes more ball impact to destroy the brick. Another brick I
added to the game is **TitaniumBrick** which is similar to the **SteelBrick** but has a low probability of breaking.

###Info Page

I added an Info Page that can only be accessed in the main menu which briefly describes the objective of the Brick Breaker game. You have the option to press a button to 
exit the info page and back to the Home Menu. 

###Home Menu background

I made a Home Menu backdrop with the button that are able to Start the game, exit the game, display info page, and display the high-score list

------------------------------------------------------------------------------------------------------------------------------------------------------------
##Notes

###At the start of the coursework only God and I know what I was doing. But now only God knows what I did.