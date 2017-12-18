# Rain Run

Game allowing user to control a character using keyboard input, where the user must make quick decisions to navigate a terrain.

To run:
1. Download this repository.
2. Run the file RainRunGUI.java

```
cd path/to/rain-run
javac RainRunGUI.java
java RainRunGUI
```

## To Do

#### Commenting
* FallingObject
* HealthPowerUp
* MyCharacter
* PowerUp
* RainDrop
* RRConstants
* SpeedPowerUp
* TextPanel
* UmbrellaPowerUp

## Done

#### Finished commenting
* ✓ Character - Angelina
* ✓ CreditsPanel - Angelina
* ✓ DeadPanel
* ✓ MainMenuPanel
* ✓ RainRun - Angelina
* ✓ RainRunGUI
* ✓ RainRunPanel - Angelina
* ✓ RulesPanel
* ✓ Score - Angelina
* ✓ ScoresPanel

## Rules

1. You control the character at the bottom using the left/right or A/D keys.
2. Avoid the falling monsters in blue.
3. Catch different powerups to gain special advantages! 
4. Over time the monsters will start to get bigger and the game will start to move faster.
5. The game ends when you lose each of your 3 lives.

## Notes

1. Monsters move straight down; Powerups zig zag.
2. The maximum speed you can attain is 10 (characters move down approximately 10 pixels every 25 milliseconds).
3. The maximum amount of lives you can attain is 3. Lose all, and you'll die!
4. You can pause/unpause the game by clicking the yellow pause button or by hitting the space bar.

## Powerups

**Health Powerup**

![alt text][health]

Will give you one additional life if you have less than 3 lives currently, as well as giving you a bonus 10 points.

**Speed Powerup**

![alt text][speed]

Will increase the pace of the game, and will also increase the amount your score increases by each time interval.

**Umbrella Powerup**

![alt text][umbrella]

Gives you a free 50 extra points!

[health]: images/heart2.png "Health Powerup"
[speed]: images/speed2.png "Speed Powerup"
[umbrella]: images/umbrella2.png "Umbrella Powerup"
