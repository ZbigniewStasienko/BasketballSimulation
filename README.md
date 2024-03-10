# Basketball 3x3 Simulation
This project is a simple simulation of a 3x3 basketball game implemented in Java. It provides an environment where users can simulate matches between two teams, each consisting of three players.

## Features
### Team creation
You decide whether you want to load players via the *data.txt* file or generate them randomly. At the very beginning of the file there is a convention in which the players parameters should be provided. Customize the file to your liking!
  
![welcome2](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/c04e15e1-f8a9-42df-95e9-064385565860)

### Number of matches 
At the beginig you can also adjust number of matches to be played.

![welcome1](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/e5065098-2c66-479b-9b9b-1bd13f0786a1)

### Simulation course
Thanks to the GUI window, you can watch the matches live and adjust the speed of the entire simulation using the slider at the top. 
In addition to the position of the players, the window informs us with appropriate messages how the action ended.

![1 — kopia](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/064fcd66-1881-44da-97fa-9ddba566ae36)
![4 — kopia](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/3688e311-e0a1-42f8-840b-f616d8ea657e)
![3 — kopia](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/bebe8fac-d607-47a0-87f9-7022b335116d)
![2 — kopia](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/6de67f2f-6897-4825-af18-98bb35f26d88)


A detailed description of what happened in each action can be found in the *simulation.txt* file. Below is a fragment of the simulation description:

![action](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/0a274991-5eea-46cb-9792-9171de7ce052)

### Simulation results

In addition to the course of each action, the *simulation.txt* file also contains a summary of a single match along with the statistics achieved by each player:

![one_game](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/e0888aef-a0ee-4adc-b5d7-5602d8f37a71)


At the end of the file there are average statistics for each player calculated from the series of matches played.


There is also summary that shows scores of each game:

![summary](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/cb188f05-e1c6-4045-aff9-9d538de48c92)

### Additional features
The simulation also includes a number of other functionalities:


-Only guards and a forwards can make an interception (if the player with the ball decides to dribble).


-Only centers can rebound the ball (offensive and defensive rebounds) and block shots.


-The position of the defender changes depending on whether we are in front of the basket or to the side.


![5](https://github.com/ZbigniewStasienko/BasketballSimulation/assets/140521815/a702d292-7226-4493-9958-46ab39444043)


-The further a player is from the basket, the less likely his shot will be accurate (as in real life).

## How to Run:

### Prerequisites:

Make sure you have Java installed on your system. You can check by opening a terminal and typing:

    java -version

If no version is shown, you can download it using the following [link](https://www.java.com/en/download/help/download_options.html)
### Running the Application:

To run the application you can just download *BasketballSimulation.jar* and double click on it to run simulation.

Alternatively, if you want to also look at the source code follow this steps:

1) Clone the repository


```
git clone https://github.com/ZbigniewStasienko/BasketballSimulation
```


2) Open the project in the [Intellij](https://www.jetbrains.com/idea/) environment and run the WelcomeGUI class.

When you run the project, follow the instructions displayed in the GUI windows



