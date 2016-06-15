package ep;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * ErixClone - a robot by Eric
 */
public class ErixClone extends Robot
{
Integer Random = new Integer(1);
	/**
	 * run: ErixClone's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		 setColors(Color.green,Color.green,Color.green); // body,gun,radar
		double heading = getHeading();
		if(heading > 180) {
			turnRight(360 - heading);
		}
		else {
			turnLeft(heading);
		}
		ahead((getBattleFieldHeight() / 2) - getY());
		turnRight(90);
		ahead((getBattleFieldWidth() / 2) - getX());
		turnLeft(90);
		// Robot main loop
		while(true) {
			
			
			if(getOthers() < 2) {
					// Assertive Mode
					
				System.out.println("Assertive mode active.");
				Random = new Integer(100);
				turnRight(180);
				ahead(Random);
				turnGunRight(360);
				back(Random);
				turnRight(180);
				System.out.println("Currently at x:" + getX() + " and y:" + getY() + " and traveling at:" + getVelocity());
			}
			else if(getOthers() < 4) {
					// Regular Mode
				if(getOthers() > 1) {
					System.out.println("Regular mode active.");
					setAdjustGunForRobotTurn(false);
					ahead(100);
					turnGunRight(360);
					turnRight(90);
					turnGunRight(360);
					System.out.println("Currently at x:" + getX() + " and y:" + getY() + " and traveling at:" + getVelocity());
				}
			}
			else {
					//Dodging Mode
					
				setAdjustGunForRobotTurn(true);
				System.out.println("Dodging mode actve.");
				turnLeft(45);
				ahead(10);
				turnGunRight(360);
				back(10);
				turnGunRight(45);
				System.out.println("Currently at x:" + getX() + " and y:" + getY() + " and traveling at:" + getVelocity());
			}
				

		}

	}
		
	

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		setColors(Color.red,Color.red,Color.red);
		fire(5);
		setColors(Color.green,Color.green,Color.green);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
		System.out.println("I've been hit!");
		ahead(20);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
		System.out.println("Whoops!");
	}	
}
