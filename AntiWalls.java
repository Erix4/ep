package ep;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * AntiWalls - a robot by (your name here)
 */
public class AntiWalls extends Robot
{
double side = 1.0;
Integer back = new Integer(6);
Integer fire = new Integer(0);
	/**
	 * run: AntiWalls's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		 setColors(Color.blue,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			back = new Integer(6);
			fire = new Integer(0);
					System.out.println("Position finder initialized.");
					System.out.println("Facing: " + getHeading());
					double heading = getHeading();
			
					if(heading > 180) {
						turnRight(360 - heading);
					}
					
					else {
						turnLeft(heading);
					}
					System.out.println("Facing: " + getHeading());
					ahead((getBattleFieldHeight() / 2) - getY());
					turnRight(90);
					ahead((getBattleFieldWidth() / 2) - getX());
					turnLeft(90);
					System.out.println("Position finder terminated. Now at " + getX() + ", " + getY());

					System.out.println("Finding walls...");
					
					scan();
					turnRight(360);
					System.out.println("Initializing movement. Facing " + getHeading() + ".");
					if(side < 2) {
						turnRight(45);
						ahead(100);
						while(fire == 1) {
							ahead(1);
							
							fire(1);
							
							System.out.println("Fire sucsessful.");
						}
					}
					
					else if(side == 2) {
						turnRight(135);
						ahead(100);
						while(fire == 1) {
							ahead(1);
							
							fire(1);
							
							System.out.println("Fire sucsessful.");
						}
					}
					
					else if(side == 3) {
						turnLeft(135);
						ahead(100);
						while(fire == 1) {
							ahead(1);
							
							fire(10);
							
							System.out.println("Fire sucsessful.");
						}
					}
					
					else {
						turnLeft(45);
						ahead(100);
						while(fire == 1) {
							ahead(1);
							
							fire(1);
							
							System.out.println("Fire sucsessful.");
						}
					}
					System.out.println("Movement terminated.");
				
				
				
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		
	
		System.out.println("Walls found.");
		if(getHeading() < 91) {
			side = (2);
		}
		else if(getHeading() < 181) {
			side = (3);
		}
		else if(getHeading() < 271) {
			side = (4);
		}
		else {
			side = (1);
		}
		System.out.println("Walls at side " + side);
		if(fire == 1) {
			fire = new Integer(0);
			System.out.println("End fire.");
		}
		else {
			fire = new Integer(1);
			System.out.println("Initialize fire.");
		}
		
		
		
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		System.out.println("Report-damage taken.");
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onBulletHit(BulletHitEvent e) {
		System.out.println("Report-" + e.getName() + " has been struck.");
		fire = new Integer(0);
	}
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		System.out.println("Position finder failed.");
		back(20);
	}	
}
