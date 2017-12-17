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

* Commenting:
    * ✓ Character - Angelina
    * ✓ CreditsPanel - Angelina
    * DeadPanel
    * FallingObject
    * HealthPowerUp
    * MainMenuPanel
    * MyCharacter
    * PowerUp
    * RainDrop
    * ✓ RainRun - Angelina
    * RainRunGUI
    * RainRunPanel - Angelina
    * RRConstants
    * RulesPanel
    * Score - Angelina
    * ScoresPanel - Angelina
    * SpeedPowerUp
    * TextPanel
    * UmbrellaPowerUp
* Create a new credits panel with our names and contributors

## Technical specifications

### Character - DONE (Angelina)
* Character interface specifies what properties Characters have
* Think of each object appearing on RainRunPanel as a Character / sometimes a FallingObject

### FallingObject - DONE
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

Will increase the pace of the game, and will also increase the amount your score increases by each time interval.

![alt text][umbrella]

**Umbrella Powerup**

Gives you a free 50 extra points!

[health]: images/heart2.png "Health Powerup"
[speed]: images/speed2.png "Speed Powerup"
[umbrella]: images/umbrella2.png "Umbrella Powerup"
