# Rain Run

Simple Java game allowing user to control a character using keyboard input, where the user must make quick decisions to navigate a terrain.

To run:
1. Download this repository.
2. Run the file RainRunGUI.java

```
cd path/to/rain-run
javac RainRunGUI.java
java RainRunGUI
```

## To Do

### Data Structures

* Hash Tables for case and effect for implementHit

* Stack for hearts/lives 

* Hash Tables for scores 


### Mara

* Edit the graphics of the main character and the monsters to look nicer.
* Update backend classes 

### Angelina

* Examine RainRunPanel for code to be moved to 

### Isabel

* Create a main menu to start the game from.
* When a game has ended, insert a button they can press to return to the main menu.
* Create a rules panel explaining the rules of the game, to link from the main menu.

### Hunter


* DeadPanel 
* FallingObject
* Start slides 



### Other 

* Figure out how to toggle between different panels based on buttons.
* [Optional] Make monsters move down in a less choppy fashion (can maybe use another timer to achieve this and modify the moveDown methods)
* [Optional] Include a pause button, such that the user can manually pause the game when they want.


## Extras

* [Optional] Allow the user to choose what color their character should be, and/or different themes.
* [Optional] Include "themes" / "levels" in our game, where periodically the background / monster colors change.


## Technical specifications

### Character - DONE (Angelina)
* Character interface specifies what properties Characters have
* Think of each object appearing on RainRunPanel as a Character

### FallingObject - 
* maybe: create a new class for all Characters that fall (monsters, powerups)

### MyCharacter - Mara
* Attributes: died; health;

### Monster - Mara
* Attributes: moveDown();

### RainRun
* Attributes: score; time; scoreInc; speed; monsters / powerUps (maybe Vector<FallingObject>); addElInterval; increaseSizeInterval; increaseSpeedInterval;

### PowerUp
* Method: moveDown(int speed) <-- probably wants to zig zag differently based on speed


## Rules

1. You control the character at the bottom using the left/right or A/D keys.
2. Avoid the falling monsters in blue.
3. Catch different powerups to gain special advantages! 
4. Over time the monsters will start to get bigger and the game will start to move faster.
5. The game ends when you lose each of your 3 lives.

## Notes

1. Monsters move straight down.
2. Bigger monsters move faster - watch out!
3. Powerups zig zag.

## Powerups

![alt text][health]

**Health Powerup**

Will give you one additional life if you have less than 3 lives currently, as well as giving you a bonus 10 points.

![alt text][speed]

**Speed Powerup**

Will increase the pace of the game, and will also double the amount your score increases by each time interval.

![alt text][umbrella]

**Umbrella Powerup**

Gives you a free 100 extra points!

[health]: images/heart2.png "Health Powerup"
[speed]: images/speed2.png "Speed Powerup"
[umbrella]: images/umbrella2.png "Umbrella Powerup"
