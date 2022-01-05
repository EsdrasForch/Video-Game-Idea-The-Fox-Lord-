# Video-Game-Idea (The Fox Lord)
CMP 428 - Final Project

# The Fox Lord is: 🦊
The Fox Lord is a beta version for an exciting and dark 2D platformer game written in java. In this beta version, you are able to run, jump and fly through a gorgeous dark forest which I named "The Grimwoods" 
in which you need to escape from. Once you get close enought to the exit, do not fear and do not falter. The game uses collision detection to activate certain events, such as the boss fight and your ultimate attack. Proceed with caution and defeat the boss. It is the only way that you will be able to escape into the real world.

# A tiny pinch of lore: 🤏🏻
The Fox Lord is a grim and dark tale about lost souls and dark fantasy. The tiny little fox, is known as the last foxunion soul. The foxunion was a tribe of noble heroes, who fought valiantly in the plains of reality, to preserve the peace of the land. One day, one of the many tribes, received a blessing. They received a soul, as ancient and mysterious as the Green Knight. For a time, this mysterious tribe, used their blessing to gift themselves power and prosperity. But soon, they began to notice the true raw power that came with this soul. It had the power to bend reality, to conquer worlds and to steal power. They planned an attack, thirsty for more power, they sought out the ones who had it all since the beggining and slayed the entirety of the foxunion race. This tribe conquered the world. And they were known, as the wolfcrux. As time goes on, and centuries pass, a new blessing came into this world. A blessing for the honorable. A foxunion soul was created at the edge of time and space. In a dark forest, where the corrupted and dead watch and exist. This is the beggining of a new era. The era of the fox lord.  

![alt text]

# How it works: ✨
- I created an array to store all of my key-events and then turned them all into static variables so that I am able to use them in every single class that I make. Thanks to these key-events, I am able to move around my scene, jump and fly.

- I created an image layer class that will allow me to create a layered ilusion in my background. I created a for loop inside of my draw method that would keep on drawing my background images multiple times in order to create an ilusion of a never ending forest. I then added an offset of 725 in order to prevent the images from overlapping or being to far away from each other, breaking the ilusion. The 2D scrolling is finally possible thanks to one of the constructors in this class, that allows me to assign the speed in which all of the images will scroll allongside with the camera. The game-loop will then bring all of these objects and methods to life using a while loop and conditional statements to make sure that everything runs in real time.

- I also created a format string inside of the constructor that is in charge of giving life to our sprite that would allow me to see his current x and y location inside of the scene. This allowed me to create objects more easily by printing those locations in the console and then assigning that x and y value to my other objects. 

- The sprite class is one of the most important classes in this program and it ensures that the sprite is able to come to life. It holds the sprite constructor that allows me to retrieve my file, assign the location in which it will be drawn, assing the height and width of my hitbox, as well as add the many poses that the sprite has, in order to animate them.

- I also used collision detection in order to be able to spawn the boss and your ultimate attack. I created a rectangle class and then used it to create small rectangular objects at the very end of the scene and used conditional statements that would only draw them if the fox overlaps these small rectangles.

# Youtube Video: 🎥

https://youtu.be/0vENGuk-wGc

# Finally: 🧚
- “Copyright Disclaimer under section 107 of the Copyright Act of 1976, allowance is made for “fair use” and all of the assets and pictures that I used for this project are solely for the purposes of my education. 
