package ep;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * ErixClone2 - a robot by (your name here)
 */
public class ErixClone2 extends Robot
{

	/**
	 * run: ErixClone2's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:		
		double heading = getHeading();
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		System.out.println("Initliazing systems.");
		ahead(10);
		System.out.println("Movement active.");
		turnRight(360);
		System.out.println("Agility acitve.");
		fire(1);
		System.out.println("Weapons active.");
		System.out.println("All systems active.");
		System.out.println("Intilializing position finder, Stage 1.");
		if(heading > 180) {
			turnRight(360 - heading);
		}
		else {
			turnLeft(heading);
		}
		System.out.println("Stage 1 terminated.");
		System.out.println("Stage 2 initialized.");
		ahead((getBattleFieldWidth() / 2) - getY());
		turnRight(90);
		ahead((getBattleFieldHeight() / 2) - getX());
		turnLeft(90);
		System.out.println("Position finder terminated.");
		System.out.println("Position status- X: " + getX() + ", Y: " + getY());
		System.out.println("Initiliazer terminated. Begin program.");
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
