<h1><i>PathFinder-2</i> </h1>
<h2>GIF</h2>

!["PathFinderGif"](image/PathFinderGif.gif)
<!-- <img src="image/ss-cmd.png" alt="Resim 1" width="50%"><img src="image/ss-netbeans.png" alt="Resim 2" width="50%">-->

<h2> Netbeans Output</h2>

!["PathFinderGif"](image/ss-netbeans.png)

<h2> Windows </h2>

!["PathFinderGif"](image/ss-cmd.png)




<br>
<h2>Video Links</h2>

* <a href="https://www.youtube.com/watch?v=BNGwhRaB7dY"> Youtube Link </a>
* <a href="https://www.linkedin.com/posts/ahmeteminsaglik_java-algorithm-algorithms-activity-7065611128730529792-801X/?utm_source=share&utm_medium=member_desktop"> Linkedin Link </a>

<br>
<h2>Introduction</h2>
This project is the second version of the project <a href="https://github.com/AhmetEminSaglik/PathFinder-1"><i>PathFinder-1</i></a>. This version generates a lot of bridges. And then finds all paths from the start location to the exit location. Then sort them from shortest to longest steps. The main purpose of the project is to show shortest way.
<br>

<h2>How Does Work?</h2><br>
The car/robot follows these steps (basically): 
<br><br>
1-) If exit location is found, go last <i>jumper location</i>
2-) If bridge is available add this location to <i>jumper_location_array</i>  then go upwards<br>
2-) Else, if moving in the right direction and there is an available square, proceed in the right direction<br>
4-) Else, move towards the reference point.<br>
5-) Go left direction.
<br><br>
Here is a basic code these steps to understand better :
<br><be>


        if (car.location.getX() ==exit.location.getX() &&  car.location.getY() ==exitLocation.getY()){
            car.location.setX(jumperLocation.popX());
            car.location.setY(jumperLocation.popY());
        } else if (bridge.isAvailable) {
            jumperLocation.add(i,j);
            goUp();
        } else if (car.direction = Direction.RIGHT && rightPath.isAvailable()) {
            goRight();
        } else if (goingRight() && rightPath.isAvailable() == false) {
            goReferanceLocation();
            car.setDirection(Direction.LEFT);
        } else {
            goLeft();
        }
        
<h2> Why the project is created</h2>
The project was created to improve algorithm skills in 2019 (first year at University). 

<h2>Requirements</h2>

The project can run `JDK 1.8+`

<h2>How to Run</h2>

1-) Install these :
<br>
* <a href="https://www.oracle.com/java/technologies/downloads/#java8">Java SE Development Kit 8 (JDK 8)</a>
* After installing JDK 8, install <a href="https://netbeans.apache.org/front/main/download/index.html">NetBeans IDE</a>

2-) Copy and paste following command in your cmd. 
```
git clone https://github.com/AhmetEminSaglik/PathFinder-2.git
```
3-) Open Netbeans and open the project where did you clone.

4-) Project is ready to run.